/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_huffman;

/**
 *
 * @author josue
 */
public class ArbolHuffman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
        String txt = Util.leerTexto("./src/arbol_huffman/texto.txt");
        System.out.println(Util.calcularFrecuencias(txt));
        String txt2 = Util.leerTexto("./src/arbol_huffman/prueba.txt");
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
    }
    
}
