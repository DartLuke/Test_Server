package com.request;

import com.singleton.Singleton;
import com.testServer.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class Server {

    //first step
    @RequestMapping(value = "api/utility/createPaymentInfo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> createPaymentInfo(@RequestBody CreatePaymentInfo createPaymentInfo) {
        Singleton singleton = Singleton.getInstance();
        Map<String, Object> res = new HashMap<>();
        String GUID = UUID.randomUUID().toString();
        // GUID = "1";
        singleton.setGUID(GUID);
        res.put("ServiceSessionId", GUID);


        System.out.println("receiving request");
        System.out.println("api/utility/createPaymentInfo");
        System.out.println("Generating Session Id "+GUID);
        return new ResponseEntity<Map>(res, HttpStatus.OK);
    }

    //step two
    @RequestMapping(value = "api/gateway/processPayment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> processPayment(@RequestBody ProcessPayment processPayment) {
        Singleton singleton = Singleton.getInstance();
        singleton.setProcessPaymentMap(processPayment);
        Map<String, String> res = new HashMap<>();

        if (processPayment == null) {
            res.put("Status", "Error, processPayment is null");
            return new ResponseEntity<Map>(res, HttpStatus.BAD_REQUEST);
        }


        System.out.println("receiving request");
        System.out.println("api/gateway/processPayment");
        System.out.println("Session Id="+processPayment.getPaymentRequest().getServiceSessionId());

        processPayment.getPaymentRequest().getServiceSessionId().trim();
        processPaymentProcessing(processPayment.getPaymentRequest().getServiceSessionId());
        res.put("Status", "Ok");
        return new ResponseEntity<Map>(res, HttpStatus.OK);
        //   return new ResponseEntity<ProcessPayment>(processPayment, HttpStatus.OK);
    }

    private void processPaymentProcessing(String GUID) {
        new Client().ProcessPaymentCallBack(GUID);
    }

    //step four
    @RequestMapping(value = "api/gateway/processCommand", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> processCommand(@RequestBody ProcessCommand processCommand) {
        System.out.println("receiving request");
        System.out.println("api/gateway/processCommand");
        System.out.println("Session Id="+processCommand.getSessionId());

        new Client().ProcessCommandCallBack(processCommand);




        Map<String, String> res = new HashMap<>();
        res.put("Status", "Ok");

       // return new ResponseEntity<ProcessCommand>(processCommand, HttpStatus.OK);
        return new ResponseEntity<Map>(res, HttpStatus.OK);
    }

    //Step six
    @RequestMapping(value = "api/gateway/processResponse", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> processResponse(@RequestBody ProcessResponse processResponse) {
        System.out.println("receiving request");
        System.out.println("api/gateway/processResponse");
        System.out.println("Session Id="+processResponse.getSessionId());



        new Client().ProcessPaymentCallBack(processResponse.getSessionId());
        Map<String, String> res = new HashMap<>();
        res.put("Status", "Ok");
        return new ResponseEntity<Map>(res, HttpStatus.OK);

    }
}
