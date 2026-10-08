

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

        String classpath = System.getProperty("java.class.path");
        
        ProcessBuilder pbError = new ProcessBuilder("java", "-cp", classpath, "FiltreLog");
        ProcessBuilder pbWarning = new ProcessBuilder("java", "-cp", classpath, "FiltreLog","WARNING");
        
        File errors = new File("errors_filtre.log");
        File warnings = new File("warnings_filtre.log");

        pbError.redirectError(errors);
        pbWarning.redirectError(warnings);

        String textProva = """
                                           Another one got caught today, it's all over the papers.  "Teenager
                                           Arrested in Computer Crime Scandal", "Hacker Arrested after Bank Tampering"...
                                                   Damn kids.  They're all alike.
                                                                    But did you, in your three-piece psychology and 1950's technobrain,
                                           ever take a look behind the eyes of the hacker?  Did you ever wonder what
                                           made him tick, what forces shaped him, what may have molded him?
                                                   I am a hacker, enter my world... ERROR WARNING
                                                   ERROR WARNING
                                                   
                                                   ERROR WARNING                            """ //
                    //
                    //
                    //
                    //
                    //
                    //
                    ;

        Process fillError = pbError.start();
        Process fillWarning = pbWarning.start();

        BufferedWriter out = new BufferedWriter(new PrintWriter(fillError.getOutputStream()));                      
            out.write(textProva);
            out.newLine();
            out.flush();
            out.close();

        BufferedWriter outW = new BufferedWriter(new PrintWriter(fillWarning.getOutputStream()));
            outW.write(textProva);
            outW.newLine();
            outW.flush();
            outW.close();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(fillError.getInputStream()));
        String error = in.readLine();
        in.close();

        BufferedReader inW = new BufferedReader(new InputStreamReader(fillWarning.getInputStream()));
        String warning = inW.readLine();
        inW.close();

        if(fillError.waitFor(duration)){
            switch (fillError.exitValue()) {
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
            fillError.destroy();
        }
        
        if(fillWarning.waitFor(duration)){
            switch (fillWarning.exitValue()) {
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
            fillWarning.destroy();
        }

        int exitCode = 1;
        if(fillError.exitValue() == 0 && fillWarning.exitValue() == 0){exitCode = 0;}

        System.out.println("RESULTAT: ERRORS="+error+" | WARNINGS="+warning+" | EXIT_CODE="+exitCode);

    }
}
