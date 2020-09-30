package com.TestData;

import com.singleton.Singleton;
import com.testServer.model.ProcessPayment;

import java.util.Map;

public class TestReport {
   private Map<String, ProcessPayment> map;
    private final String separator = "**************************************************************************************************";
    public TestReport() {
        this.map = Singleton.getInstance().getProcessPaymentMap();

    }



    public void start() {
        System.out.println("Starting test report...");
        String GUID;
        ProcessPayment processPayment;
        CheckList checkList;
        for (Map.Entry<String, ProcessPayment> entry : map.entrySet()) {
            GUID = entry.getKey();
            processPayment = entry.getValue();
            checkList = entry.getValue().getCheckList();

           System.out.println("GUID: "+GUID);
           System.out.println("Process Payment NodeId: "+processPayment.getNodeId());

            System.out.println("CreatePaymentInfo:\n"+
                    checkList.getCreatePaymentInfo().getUrl()+" "
                    +checkList.getCreatePaymentInfo().isDone());

            System.out.println("getProcessPayment():\n"+
                    checkList.getProcessPayment().getUrl()+" "
                    +checkList.getProcessPayment().isDone());


            System.out.println("Complete command:\n"+
                   checkList.getCompleteCommand().getUrl()+" "
                   +checkList.getCompleteCommand().isDone());
           func1(checkList);
           for(int i=0; i<processPayment.getRoute().length; i++)
           {
               System.out.println(separator);
               checkList= processPayment.getRoute()[i].getCheckList();
               System.out.println("NodeId: "+ processPayment.getRoute()[i].getNodeId());
               func1(checkList);
           }
System.out.println(separator);
            System.out.println(separator);

        }


    }

    private void func1(CheckList checkList)
    {
        System.out.println("ProcessPaymentCallBack\n url=" +
                checkList.getProcessPaymentCallBack().getUrl() + " " +
                checkList.getProcessPaymentCallBack().isDone()
        );

        System.out.println("ProcessCommand\n url=" +
                checkList.getProcessCommand().getUrl()+ " " +
                checkList.getProcessCommand().isDone()
        );

        System.out.println("ProcessResponse\n url=" +
                checkList.getProcessResponse().getUrl()+ " " +
                checkList.getProcessResponse().isDone()
        );

        System.out.println("ProcessCommandCallBack()\n url=" +
                checkList.getProcessCommandCallBack().getUrl()+ " " +
                checkList.getProcessCommandCallBack().isDone()
        );
    }
}
