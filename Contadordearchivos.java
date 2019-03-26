/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contadordearchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Contadordearchivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
    File directorio = new File("C:\\Users\\Leo\\Documents\\leo\\basededatos\\howto"); //directorio a listar
    String vardirectorio = "";
        
        String[] lista = directorio.list();
        Arrays.sort(lista);
        for (int i = 0; i < lista.length; i++) {
            
        try {
            System.out.print(lista[i]+" ");
            directorio = new File("C:\\Users\\Leo\\Documents\\leo\\basededatos\\howto\\"+lista[i]);
            String linea;
            int clinea = 0;
            FileReader fr = new FileReader(directorio);
            BufferedReader br = new BufferedReader(fr);
            int c, j, a = 0;
            while ((linea = br.readLine()) != null) {
                clinea++;
                for (c = 0; c < linea.length(); c++) {
                    if (c == 0) {
                        if (linea.charAt(c) != ' ') {
                            a++;
                        }
                    } else {
                        if (linea.charAt(c - 1) == ' ') {
                            if (linea.charAt(c) != ' ') {
                                a++;
                            }
                        }

                    }
                }
            }
            System.out.print(a + " palabras ");
            System.out.println(clinea +" lineas");
        } catch (IOException ex) {
            Logger.getLogger(Contadordearchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
}


