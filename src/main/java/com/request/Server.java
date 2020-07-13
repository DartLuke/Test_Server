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
        GUID = "1";
        singleton.setGUID(GUID);
        res.put("ServiceSessionId", GUID);

        return new ResponseEntity<Map>(res, HttpStatus.OK);
    }

    //step two
    @RequestMapping(value = "api/gateway/processPayment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> processPayment(@RequestBody ProcessPayment processPayment) {

        Singleton singleton = Singleton.getInstance();
        singleton.setProcessPaymentMap(processPayment);
        Map<String, String> res = new HashMap<>();

       


        System.out.println(processPayment);

        //**********************************************
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        processPaymentProcessing(processPayment.getPaymentRequest().getServiceSessionId());
        res.put("Status", "Ok");
       //return new ResponseEntity<Map>(res, HttpStatus.OK);
        return new ResponseEntity<ProcessPayment>(processPayment, HttpStatus.OK);
    }

    private void processPaymentProcessing(String GUID) {
       new Client().ProcessPaymentCallBack(GUID);
    }

    //step four
    @RequestMapping(value = "api/gateway/processCommand", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> processCommand(@RequestBody ProcessCommand processCommand) {
        System.out.println("processCommand");

        new Client().ProcessCommandCallBack(processCommand);



        ProcessCommand pc = new ProcessCommand("a", "a", "a", "a", "a", "a");

        System.out.println(pc);

        return new ResponseEntity<ProcessCommand>(pc, HttpStatus.OK);
    }

    //Step six
    @RequestMapping(value = "api/gateway/processResponse", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> processResponse(@RequestBody ProcessResponse processResponse) {




new Client().ProcessPaymentCallBack(processResponse.getSessionId());
        Map<String, String> res = new HashMap<>();
        res.put("Status", "Ok");
        return new ResponseEntity<Map>(res, HttpStatus.OK);

    }
}
