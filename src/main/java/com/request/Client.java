package com.request;

import com.singleton.Singleton;
import com.testServer.model.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


public class Client {

    //private    String url = "http://localhost:8080";7
    String separator = "**************************************************************************************************";
    private WebClient webClient = WebClient.builder().build();//.baseUrl(url).build();
    Singleton singleton = Singleton.getInstance().getInstance();

    public void ProcessPaymentCallBack(String GUID) {

        ProcessPayment processPayment = singleton.getProcessPayment(GUID);
        UtilityCommand utilityCommand;
        String nodeId = processPayment.getMyNodeId();

        if (nodeId == null) {
            singleton.checkProcessPayment(GUID);
            String str = "Session id " + GUID + "\n" +
                    "End of node array\n " +
                    "Sending Request\n" +
                    processPayment.getStatusCallbackUrl() + "\n";
            webClient.post()
                    .uri(processPayment.getStatusCallbackUrl())
                    .body(Mono.just(new CompleteCommand(1, GUID)), CompleteCommand.class)
                    .exchange().subscribe(clientResponse ->

                    System.out.println(separator + "\n" + str + "\nResponse code " + clientResponse.statusCode() + "\n" + separator));

           if(singleton.isAllchecked()) {
               System.err.println("**************************************************************************************************************");
               System.err.println("**************************************************************************************************************");
               System.err.println("**************************************************************************************************************");
               System.err.println("**************************************************************************************************************");
           }
            return;
        }

        utilityCommand = new UtilityCommand(0, "command_body", processPayment.getCallbackUrl(), "command_id", nodeId, GUID);


        processPayment.setCheckListProcessPaymentCallBack(processPayment.getCallbackUrl());


        String str = "Sending Request\n" +
                processPayment.getCallbackUrl() +
                "\nSession id " + GUID + "\n"
                + "NODE ID: " + nodeId;

        // final ProcessCommand[] pc = new ProcessCommand[1];
        //Mono<ProcessCommand> responseMono =
        int i = processPayment.getCounter();
        webClient.post()
                .uri(processPayment.getCallbackUrl())
                .body(Mono.just(utilityCommand), UtilityCommand.class)
                .exchange().subscribe(clientResponse ->

                {
                    processPayment.setCheckListProcessPaymentCallBack(true, i);
                    System.out.println(separator + "\n" + str + "\nResponse code " + clientResponse.statusCode() + "\n" + separator);

                }
        );

        processPayment.counterPlus();
    }

    //step three 5;
    public void ProcessCommandCallBack(ProcessCommand processCommand) {


        if (processCommand.getCallbackUrl() == null) {
            System.err.println("Can't find URL");
            return;
        }
        String str = "Sending Request\n" + processCommand.getCallbackUrl();
        if (processCommand.getSessionId() != null)
            str = str + "\nSession id " + processCommand.getSessionId();
        if (processCommand.getNodeId() != null)
            str = str + "\nNODE ID: " + processCommand.getNodeId();

        String finalStr = str;


        ProcessPayment processPayment = Singleton.getInstance().getProcessPayment(processCommand.getSessionId());
        processPayment.setCheckListProcessCommandCallBack(processCommand.getCallbackUrl(), processCommand.getNodeId());

        webClient.post()
                .uri(processCommand.getCallbackUrl())
                .body(Mono.just(new ResponseCommand(processCommand)), ResponseCommand.class)
                .exchange().subscribe(clientResponse ->
                {
                    System.out.println(
                            separator + "\n" +
                                    finalStr + "\nResponse code " + clientResponse.statusCode() + "\n" + separator);

                    processPayment.setCheckListProcessCommandCallBack(true, processCommand.getNodeId());
                }
        );


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

//    private void start() {
//        if (thread == null) {
//            thread = new Thread(this);
//            thread.start();
//        }
//    }


//    @Override
//    public void run() {
//        if (funcID == PROCESS_PAYMENT_CALL_BACK)
//            ProcessPaymentCallBack();
//else
//    if(funcID==Process_Command_CallBack);
//        ProcessCommandCallBack();
//    }
}
