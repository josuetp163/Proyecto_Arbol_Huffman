/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.main;

import arbol_huffman.ArbolHuffman;
import arbol_huffman.Util;
import ec.edu.espol.constants.Constantes;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author micharce
 */
public class Main {
    public static void main(String[] args) {    
        String txt = Util.leerTexto(Constantes.RUTAFILES + "texto.txt");
        System.out.println(Util.calcularFrecuencias(txt));
        String txt2 = Util.leerTexto(Constantes.RUTAFILES + "prueba.txt");
        System.out.println(Util.calcularFrecuencias(txt2));
        // sirve
        
        String binary = "0010 0100 1001 0010 0111 0110 1101 1011 0110 1101 1000 0000 0000 0000 0101 1011 0110 " +
                        "1101 1011 0110 0100 1001 0010 0100 1111 1111 1111 1111 1111 1111 0101 0101 0101 0101 " +
                        "0101 01";
        binary = binary.replaceAll(" ", "");
        System.out.println(binary);
        String hex = Util.binarioHexadecimal(binary);
        System.out.println(hex);
        String binary2 = Util.hexadecimalBinario(hex);
        System.out.println(binary2);
        System.out.println(binary.equals(binary2));
        
        System.out.println("#####");
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,1);
        map.put(3,1);
        for(Map.Entry<Integer, Integer> i:  map.entrySet()){
            System.out.println(i);
        }
        
        System.out.println("######");
        ArbolHuffman ah = new ArbolHuffman(); 
        HashMap<String,Integer> frec = Util.calcularFrecuencias(txt2);
        ah.calcularArbol(frec);
        HashMap<String,String> codes = ah.calcularCodigos();
        System.out.println(codes);
        String codificado = ArbolHuffman.codificar(txt2, codes);
        System.out.println(codificado);
        System.out.println(ArbolHuffman.decodificar(codificado, codes));

        Util.guardarTexto("comprimido", hex, codes);
        System.out.println(Util.leerMapa("comprimido_compress.txt"));
    }
}
