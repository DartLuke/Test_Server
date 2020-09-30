package com.TestData;

public class CheckList {

    private Struct createPaymentInfo = new Struct("api/utility/createPaymentInfo");//step1

    private Struct processPayment = new Struct("api/gateway/processPayment");

    private Struct processPaymentCallBack;//step 3

    private Struct processCommand = new Struct("api/utility/processCommand");//step 4;

    private Struct processCommandCallBack;// step 5

    private Struct processResponse = new Struct("api/gateway/processResponse"); //step 6


    private Struct completeCommand; //final step

    public void setProcessPaymentCallBack(Struct processPaymentCallBack) {
        this.processPaymentCallBack = processPaymentCallBack;
    }

    public CheckList() {
        processPaymentCallBack = new Struct();
        processCommandCallBack = new Struct();
        completeCommand=new Struct();
    }

    public Struct getCompleteCommand() {
        return completeCommand;
    }

    public Struct getProcessPayment() {
        return processPayment;
    }

    public void setProcessPaymentCallBack(String url) {
        if (processPaymentCallBack == null)
            this.processPaymentCallBack = new Struct(url);
        else
            this.processPaymentCallBack.Url = url;
    }

    public void setProcessPaymentCallBack(boolean isDone) {
        this.processPaymentCallBack.isDone = isDone;
    }

    public Struct getProcessCommand() {
        return processCommand;
    }

    public void setProcessCommand(boolean isDone) {
        processCommand.isDone = isDone;
    }

    public Struct getCreatePaymentInfo() {
        return createPaymentInfo;
    }

    public Struct getProcessCommandCallBack() {
        return processCommandCallBack;
    }

    public void setCompleteCommand(String url, boolean isDone) {
        this.completeCommand.Url = url;
        this.completeCommand.setDone(isDone);
    }

    public void setProcessCommandCallBack(String url) {
        this.processCommandCallBack.Url = url;
    }

    public void setProcessCommandCallBack(boolean isDone) {
        this.processCommandCallBack.isDone = isDone;
    }

    public Struct getProcessResponse() {
        return processResponse;
    }

    public void setProcessResponse(boolean isDone) {


        processResponse.isDone = isDone;
    }

    public Struct getProcessPaymentCallBack() {
        return processPaymentCallBack;
    }

    public class Struct {
        private boolean isDone = false;

        public Struct() {

        }

        public boolean isDone() {
            return isDone;
        }

        public void setDone(boolean done) {
            isDone = done;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String url) {
            Url = url;
        }

        private String Url;

        public Struct(String url) {
            Url = url;
        }
    }
}

