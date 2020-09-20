package com.TestData;

public class CheckList {
    private Struct processPaymentCallBack;//step 3

    private Struct processCommand = new Struct("api/utility/processCommand");//step 4;

    private Struct processCommandCallBack;// step 5

    private Struct processResponse = new Struct("api/gateway/processResponse"); //step 6

    public void setProcessPaymentCallBack(Struct processPaymentCallBack) {
        this.processPaymentCallBack = processPaymentCallBack;
    }

    public CheckList() {
        processPaymentCallBack = new Struct();
        processCommandCallBack = new Struct();
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

    public Struct getProcessCommandCallBack() {
        return processCommandCallBack;
    }


    public void setProcessCommandCallBack(Struct processCommandCallBack) {
        this.processCommandCallBack = processCommandCallBack;
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

    private class Struct {
        boolean isDone = false;

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

        String Url;

        public Struct(String url) {
            Url = url;
        }
    }
}

