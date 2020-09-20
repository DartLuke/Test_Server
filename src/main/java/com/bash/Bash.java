package com.bash;

import com.singleton.Singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bash implements Runnable {

    private Thread thread;
    public final String SETUP = "./scripts/setup.sh";
    public final String VERIFY = "./scripts/verify.sh";
    public final String STOP = "./scripts/stop.sh";
    private Singleton singleton = Singleton.getInstance();

    public Bash() {
    }



    public void startInMultiThread() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void executeScriptVerify() {

        for (int i = 0; i < 100; i++) {

            if (singleton.isProcessPaymentMapEmpty()) {
                System.err.println("*********************************************************    " + i);
                executeScript(VERIFY);
            }
            else {
                System.err.println("exit  " + i);
                System.err.println(singleton.isProcessPaymentMapEmpty());
                break;
            }
        }
        System.err.println("STOP");
   //     executeScript(STOP);
    }

    public void executeScript(String scriptPath) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(scriptPath);
        try {
            System.out.println("Starting bash script");

            Process process = processBuilder.start();


            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            BufferedReader reader1 = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));

            int exitVal = process.waitFor();
            System.out.println("exitVal " + exitVal);
            Boolean print = true;
            if (print) {
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line + "\n");
                }

                System.out.println(output);
                while ((line = reader1.readLine()) != null) {
                    output.append(line + "\n");
                }

                System.out.println(output);
                System.out.println("Bash script is finished");
            } else System.out.println("Commands are finished");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {


        executeScriptVerify();
    }

}
