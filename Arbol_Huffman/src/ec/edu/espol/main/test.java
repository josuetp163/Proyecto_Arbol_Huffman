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
        String textFile = Util.leerTexto(Constantes.RUTAFILES + "prueba.txt");
                HashMap<String, Integer> frecuencias = Util.calcularFrecuencias(textFile);
                ArbolHuffman ah = new ArbolHuffman();
                ah.calcularArbol(frecuencias);
                String binary = ArbolHuffman.codificar(textFile, ah.calcularCodigos());
                String hex = Util.binarioHexadecimal(binary);
                Util.guardarTexto("copy_prueba.txt", hex, ah.calcularCodigos());

    }
    
}
