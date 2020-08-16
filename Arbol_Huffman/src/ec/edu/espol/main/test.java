/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.main;

import arbol_huffman.ArbolHuffman;
import arbol_huffman.Util;
import java.util.HashMap;

/**
 *
 * @author TBeltran
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String textFile = "dffdfdfdfdllauuuetqyepppaaabdgqge";
                HashMap<String, Integer> frecuencias = Util.calcularFrecuencias(textFile);
                System.out.println(frecuencias);
                ArbolHuffman ah = new ArbolHuffman();
                ah.calcularArbol(frecuencias);
                HashMap<String, String> codes = ah.calcularCodigos();
                System.out.println(codes);
                String binary = ArbolHuffman.codificar(textFile, codes);
                System.out.println(binary);
                String hex = Util.binarioHexadecimal(binary);
                System.out.println(hex);
                //Util.guardarTexto("test.txt", hex, ah.calcularCodigos());
    }
    
}
