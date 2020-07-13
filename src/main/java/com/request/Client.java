package com.request;

import com.singleton.Singleton;
import com.testServer.model.CreatePaymentInfo;
import com.testServer.model.ProcessCommand;
import com.testServer.model.ProcessPayment;
import com.testServer.model.UtilityCommand;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


public class Client {

 //private    String url = "http://localhost:8080";7
    private  WebClient webClient = WebClient.builder().build();//.baseUrl(url).build();
    private Singleton singleton = Singleton.getInstance();


    //step three;
    public void ProcessPaymentCallBack(String GUID) {
        ProcessPayment processPayment = Singleton.getInstance().getProcessPayment(GUID);
        UtilityCommand utilityCommand;
        if(processPayment.getCounter()==-1)
        utilityCommand = new UtilityCommand(0, "command_body", processPayment.getCallbackUrl(), "command_id", processPayment.getNodeId(),GUID);
           else if(processPayment.isEndOfArray()) return;
           else utilityCommand = new UtilityCommand(0, "command_body", processPayment.getCallbackUrl(), "command_id", processPayment.getNodeFromArray(),GUID);


        System.out.println("ProcessPaymentCallBack");


        final ProcessCommand[] pc = new ProcessCommand[1];
        //Mono<ProcessCommand> responseMono =
                webClient.post()
                        .uri(processPayment.getCallbackUrl())
                        .body(Mono.just(utilityCommand), UtilityCommand.class)
                        .exchange().subscribe(clientResponse -> System.out.println(clientResponse.statusCode()));






    }
    //step three 5;
    public void ProcessCommandCallBack(ProcessCommand processCommand) {


System.out.println(processCommand.getCallbackUrl());

        System.out.println("ProcessCommandCallBack");
        webClient.post()
                .uri(processCommand.getCallbackUrl())
                .body(Mono.just(processCommand), UtilityCommand.class)
                .exchange().subscribe(clientResponse -> System.out.println(clientResponse.statusCode()));






    }

    {
        //        final ProcessCommand[] pc = new ProcessCommand[1];
//               Mono<ProcessCommand> responseMono=
//                       webClient.post()
//                .uri("/testRequest")
//                .body(Mono.just(processPayment1), ProcessPayment.class)
//                .exchange().block().bodyToMono(ProcessCommand.class);
//
//               responseMono.subscribe(processCommand -> pc[0] =processCommand);

        //     responseMono.flatMap(clientResponse -> System.out.println(clientResponse.bodyToFlux(ProcessCommand.class)));
        //  ProcessCommand processCommand=
//                               responseMono.block().bodyToMono(String.class).block();
    }

}
