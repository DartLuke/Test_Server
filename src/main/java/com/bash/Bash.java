package com.bash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bash {
public void executeDefault()
{
   String scriptPath="./scripts/script.sh";
    executeScript(scriptPath);
}

    public void executeScript(String scriptPath) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(scriptPath);
        try {
            System.out.println("Starting bash script");
            Process    process = processBuilder.start();


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


}
