/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_huffman;

import ec.edu.espol.constants.Constantes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


/**
 *
 * @author josue
 */
public class Util {
    
    private Util() {
        
    }
    
    public static String leerTexto(String nombreArchivo){
        try(BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))){
            StringBuilder txt   = new StringBuilder();
            String line = br.readLine();
            while(line!=null){
                txt.append(line);
                line = br.readLine();
            }
            return txt.toString();
        }catch(Exception e){
        Logger.getLogger(e.getMessage());
        }
        return null;
    }
    
    public static Map<String,Integer> calcularFrecuencias(String txt){
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
    
    public static String binarioHexadecimal(String binario){
        int count = 0;
        while(binario.length() % 4 > 0){
            binario += "0";
            count++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<binario.length(); i = i+4){
            String bin = binario.substring(i, i+4);
            int decimal = binaryToDecimal(bin);
            sb.append(Integer.toHexString(decimal));
        }
        return sb.toString() + "-".repeat(count);    
    }
    
    public static String hexadecimalBinario(String hexadecimal){
        String[] digit = hexadecimal.split("");
        StringBuilder sb = new StringBuilder();
        for(String s: digit){
            if(!s.equals("-")){
                int decimal = Integer.parseInt(s,16);
                String bin = Integer.toBinaryString(decimal);
                while(bin.length()<4)
                    bin = "0" + bin;
                sb.append(bin);
            }else{
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.toString();
    }
    
    private static int binaryToDecimal(String binario){
        int decimal = 0;
        int posicion = 0;
        for (int i = binario.length() - 1; i >= 0; i--) {
            short digito = 1;
            if (binario.charAt(i) == '0') {
                digito = 0;
            }
            double multiplicador = Math.pow(2, posicion);
            decimal += digito * multiplicador;
            posicion++;
        }
        return decimal;
    }
    
    public static void guardarTexto (String nombreArchivo, String texto, Map<String,String> mapa){
        if (nombreArchivo != null && texto != null && mapa != null) { 
            try(BufferedWriter writerText = new BufferedWriter(new FileWriter(Constantes.RUTAFILES + nombreArchivo));
                BufferedWriter writerCompress = new BufferedWriter(new FileWriter(Constantes.RUTAFILES + nombreArchivo.replaceFirst(".txt", "") + "_compress.txt"))){
                writerText.write(texto);
                for(Map.Entry<String, String> code:  mapa.entrySet()){
                    writerCompress.write(code.getKey() + "=" + code.getValue());
                    writerCompress.newLine();
                } 

            } catch (IOException ex) {
                Logger.getLogger(ex.getMessage());
            }
        }
    }
    
    public static Map<String,String> leerMapa (String nombreArchivo){
        HashMap<String,String> codes = new HashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader(Constantes.RUTAFILES + nombreArchivo))){
            String line = br.readLine();
            while(line != null){
                String[] data = line.split("=");
                codes.put(data[0], data[1]);
                line = br.readLine();
            }
        return codes; 
        } catch (IOException ex) {
            Logger.getLogger(ex.getMessage());
        }
        return null;
    }
}
