/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_huffman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;


/**
 *
 * @author josue
 */
public class TDAUtil {
    public static String leerTexto(String nombreArchivo){
        try{
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            StringBuilder txt   = new StringBuilder();
            String line = br.readLine();
            while(line!=null){
                txt.append(line);
                line = br.readLine();
            }
            return txt.toString();
        }catch(Exception e){
        System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static HashMap<String,Integer> calcularFrecuencias(String txt){
       String[] arr = txt.split("");
       HashMap<String,Integer> hm = new HashMap<>();
       for(String letra : arr){
           Integer value = hm.get(letra);
           if(value == null){
               hm.put(letra,1);
           }else{
               hm.put(letra,value+1);
           }
           
       }
        return hm;
    }
}
