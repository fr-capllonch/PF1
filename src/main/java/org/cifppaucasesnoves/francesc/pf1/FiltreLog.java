package org.cifppaucasesnoves.francesc.pf1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class FiltreLog {
    
    public static void main(String[] args) throws IOException{
        
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int comptador = 0;
        String missatge;

        
            while((missatge = in.readLine()) != null){
                String[] cercaError = missatge.split(" ");

            for (String cercaError1 : cercaError) {
                if (cercaError1.contains("ERROR")) {
                    comptador =  comptador +1;
                }
            }
            }

        System.out.println(comptador);

    }
}
