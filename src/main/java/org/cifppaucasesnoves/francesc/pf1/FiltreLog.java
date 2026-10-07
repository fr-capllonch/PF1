package org.cifppaucasesnoves.francesc.pf1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class FiltreLog {
    
    public static void main(String[] args) throws IOException, InterruptedException{
        

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            boolean arxiuBuit = true;

            int comptadorError = 0;
            int comptadorFraseError = 0;
            String frase;
        
            while((frase = in.readLine()) != null){
                
                if(frase.contains("ERROR")){comptadorFraseError++;}

                arxiuBuit = false;
                String[] cercaError = frase.split(" ");

                for (String cercaError1 : cercaError) {
                    if (cercaError1.contains("ERROR")) {
                        comptadorError =  comptadorError +1;
                            
                    }
                }
            }

            if(arxiuBuit){
                System.err.println("Error: text buit");
                System.exit(1);
            }else{      
                System.out.println(comptadorError);
                System.out.println(comptadorFraseError);
                System.exit(0);
            }
    } 
    
}
