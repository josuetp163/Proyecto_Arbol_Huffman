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
public class Util {
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
    
    public static String binarioHexadecimal(String binario){
        int residuo = binario.length() % 4;
        String zeros = "0";
        StringBuilder sb = new StringBuilder();
        if(residuo != 0){
            zeros = zeros.repeat(residuo);
            binario = binario + zeros;
        }else
            zeros = "";
        for(int i = 0; i<binario.length(); i = i+4){
            String bin = binario.substring(i, i+4);
            int decimal = binaryToDecimal(bin);
            sb.append(Integer.toHexString(decimal));
        }
        return sb.toString() + "-".repeat(zeros.length());    
    }
    
    public static String hexadecimalBinario(String hexadecimal){
        String[] digit = hexadecimal.split("");
        StringBuilder sb = new StringBuilder();
        for(String s: digit){
            if(!s.equals("-")){
                int decimal = Integer.parseInt(s,16);
                String bin = Integer.toBinaryString(decimal);
                switch (bin.length()) {
                    case 1:
                        bin = "000" + bin;
                        break;
                    case 2:
                        bin = "00" + bin;
                        break;
                    case 3:
                        bin = "0" + bin;
                        break;
                    default:
                        break;
                }
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
    
   /*public int binaryToDecimal(String binary, double exp, int pos){
        if(pos == 0)
            return (int) (Double.valueOf(binary.charAt(pos))*Math.pow(2,exp));
        return Integer.valueOf(binary.charAt(pos))*Math.pow(2,exp) + binaryToDecimal(binary, 0, );Math.p
    }*/
}
