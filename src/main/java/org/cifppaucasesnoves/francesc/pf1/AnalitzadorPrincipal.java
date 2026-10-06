package org.cifppaucasesnoves.francesc.pf1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.Duration;

public class AnalitzadorPrincipal {
    public static void main(String[] args) throws IOException, InterruptedException{
        Duration duration = Duration.ofSeconds(5);
        
        Process fill = new ProcessBuilder("java", "-cp", "/home/fran/Classe/PSP/PF1/src/main/java", "org.cifppaucasesnoves.francesc.pf1.FiltreLog").start();
        BufferedWriter out = new BufferedWriter(new PrintWriter(fill.getOutputStream()));

        String textProva = """
                           Another one got caught today, it's all over the papers.  "Teenager
                           Arrested in Computer Crime Scandal", "Hacker Arrested after Bank Tampering"...
                                   Damn kids.  They're all alike.
                           
                                   But did you, in your three-piece psychology and 1950's technobrain,
                           ever take a look behind the eyes of the hacker?  Did you ever wonder what
                           made him tick, what forces shaped him, what may have molded him?
                                   I am a hacker, enter my world... ERROR""" //
        //
        //z
        //
        //
        //
        //
        ;

        out.write(textProva);
        out.newLine();
        out.flush();
        out.close();
        fill.waitFor(duration);



        BufferedReader in = new BufferedReader(new InputStreamReader(fill.getInputStream()));

        System.out.println(in.readLine());

        in.close();

    }
}
