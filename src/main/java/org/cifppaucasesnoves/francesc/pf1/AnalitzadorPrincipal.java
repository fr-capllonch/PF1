package org.cifppaucasesnoves.francesc.pf1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.Duration;

public class AnalitzadorPrincipal {
    public static void main(String[] args) throws IOException, InterruptedException{
        
        Duration duration = Duration.ofSeconds(5);
        
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "/home/fran/Classe/PSP/PF1/src/main/java", "org.cifppaucasesnoves.francesc.pf1.FiltreLog");
        

        File error = new File("errors_filtre.log");
        pb.redirectError(error);


        Process fill = pb.start();
        try (BufferedWriter out = new BufferedWriter(new PrintWriter(fill.getOutputStream()))) {
            String textProva = null;
            
            out.write(textProva);
            out.newLine();
            out.flush();
        }
        
        BufferedReader in = new BufferedReader(new InputStreamReader(fill.getInputStream()));
        System.out.println(in.readLine());
        in.close();

        boolean duracioExitosa = fill.waitFor(duration);
        if(duracioExitosa){
            switch (fill.exitValue()) {
                case 0:
                    System.out.println("El comptador ha funcionat!");
                    break;
                case 1:
                    System.out.println("El comptador no ha funcionat :(");
                    break;
                default:
                    System.err.println("Error inesperat en el comptador, no ha donat ni 0 ni 1");
                    break;
            }
        }else{
            System.out.println("El fill ha tardat massa temps");
            fill.destroy();
        }
  

    }
}
