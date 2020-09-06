/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_huffman;

import ec.edu.espol.constants.Constantes;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author micharce
 */
public class Operaciones {

    private Operaciones(){
    }
    
    public static boolean compressionProcess(File nameFile) {
        if (nameFile == null) {
            return false;
        }
        String textFile = Util.leerTexto(nameFile.getPath());
        if (textFile == null) {
            return false;
        }
        Map<String, Integer> frecuencias = Util.calcularFrecuencias(textFile);
        ArbolHuffman ah = new ArbolHuffman();
        ah.calcularArbol(frecuencias);
        String codeBinary = ArbolHuffman.codificar(textFile, ah.calcularCodigos());
        String codeHex = Util.binarioHexadecimal(codeBinary);
        Util.guardarTexto(nameFile.getName(), codeHex, ah.calcularCodigos());
        return true;
    }

    public static boolean decompressionProcess(File file, File mapFile) {
        if (file == null || mapFile == null) {
            return false;
        }
        String mapName = mapFile.getName();
        String fileName = file.getName();
        if (mapName.contains("_compress.txt")) {
            return crearNuevoTXT(fileName, mapName);
        } else if (fileName.contains("_compress.txt")) {
            return crearNuevoTXT(mapName, fileName);
        } else {
            return false;
        }
    }

    private static String decompressionProcess(String nameFile, String mapName) {
        Map<String, String> mapa = Util.leerMapa(mapName);
        String mensajeDes = Util.hexadecimalBinario(Util.leerTexto(Constantes.RUTAFILES + nameFile));
        return ArbolHuffman.decodificar(mensajeDes, mapa);
    }

    private static String descomprimir(String fileName, String mapName) {
        String mensajeDes = decompressionProcess(fileName, mapName);
        if (mensajeDes != null) {
            return mensajeDes;
        }
        return null;
    }

    private static boolean crearNuevoTXT(String fileName, String mapName) {
        String descomprimir = descomprimir(fileName, mapName);
        String nuevoNombre = "*" + fileName+ "*" + "_Descomprimido.txt";
        if (descomprimir != null) {
            try ( BufferedWriter writerText = new BufferedWriter(new FileWriter(Constantes.RUTAFILES + nuevoNombre))) {
                writerText.write(descomprimir);
                return true;
            } catch (IOException ex) {
                return false;
            }
        }
        return false;
    }
}
