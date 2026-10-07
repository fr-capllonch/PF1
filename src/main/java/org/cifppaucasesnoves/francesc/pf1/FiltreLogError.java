package org.cifppaucasesnoves.francesc.pf1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FiltreLogError {
    
    public static void main(String[] args) throws IOException, InterruptedException{
        

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            boolean arxiuBuit = true;

            String paraulaCercar;

            if(args.length > 0) {
                    paraulaCercar = "WARNING";
            }else{
                paraulaCercar = "ERROR";
            }

            int comptadorError = 0;
            int comptadorFraseError = 0;
            String frase;
        
            while((frase = in.readLine()) != null){
                
                if(frase.contains(paraulaCercar)){comptadorFraseError++;}

                arxiuBuit = false;
                String[] cercaError = frase.split(" ");

                for (String cercaError1 : cercaError) {
                    if (cercaError1.contains(paraulaCercar)) {
                        comptadorError =  comptadorError +1;
                            
                    }
                }
            }

            if(arxiuBuit){
                System.err.println("Error: text buit");
                System.exit(1);
            }else{      
                System.out.print(comptadorError);
                System.out.print(" ");
                System.out.print(comptadorFraseError);
                System.exit(0);
            }
    } 
    
}
