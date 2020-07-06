package com.request;

import com.testServer.model.ProcessCommand;
import com.testServer.model.ProcessPayment;
import com.testServer.model.UtilityCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ServerTemp {

    @RequestMapping(value = "/call_back_url", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> call_back(@RequestBody UtilityCommand utilityCommand) {
        System.out.println("call_back_url");
        //ProcessCommand processCommand = new ProcessCommand("a", "b", "c", "d", "e", "wq");
        System.out.println(utilityCommand);
        Map<String, Object> res = new HashMap<>();
        res.put("Status", "Ok");
        return new ResponseEntity<Map>(res, HttpStatus.OK);
    }


    @RequestMapping(value = "/call_back_url1", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> call_back1(@RequestBody ProcessCommand processCommand) {

        System.out.println(processCommand);
        Map<String, Object> res = new HashMap<>();
        res.put("Status", "Ok");
        return new ResponseEntity<Map>(res, HttpStatus.OK);
    }
}
