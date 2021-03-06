/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_huffman;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author josue
 */
public class ArbolHuffman {
    Node root;
    
    private class Node {
        String data;
        int frecuencia;
        Node left;
        Node right;
        
        public Node(String d, int f) {
            data = d;
            frecuencia = f;
        }
    }
    
    public void calcularArbol(Map<String,Integer> mapa) {
        PriorityQueue<Node> nodos = convertirNodos(mapa);
        Node retorno = null;
        while(!nodos.isEmpty()) {
            if (nodos.size() >= 2){
                Node a = nodos.poll();
                Node b = nodos.poll();
                Node nuevo = unirNodos(a, b);
                nodos.offer(nuevo);
            }
            else retorno = nodos.poll();
        }
        root = retorno;
    }
    
    private PriorityQueue<Node> convertirNodos(Map<String,Integer> mapa) {
        PriorityQueue<Node> retorno = new PriorityQueue<>((Node a, Node b) -> a.frecuencia - b.frecuencia);
        Set<String> keys = mapa.keySet();
        Iterator<String> it = keys.iterator();
        while(it.hasNext()) {
            String etiqueta = it.next();
            int frecuencia = mapa.get(etiqueta);
            retorno.offer(new Node(etiqueta,frecuencia));
        }
        return retorno;
    }
    
    private Node unirNodos(Node a, Node b) {
        int sumaFrec = a.frecuencia + b.frecuencia;
        String dataNode = sumaFrec + "";
        Node retorno = new Node(dataNode, sumaFrec);
        retorno.left = a;
        retorno.right = b;
        return retorno;
    }
    
    public Map<String,String> calcularCodigos() {
        return calcularCodigos(root, "");
    }
    
    private HashMap<String,String> calcularCodigos(Node n, String s) {
        HashMap<String,String> mapa = new HashMap<>();
        if (n == null) return mapa;
        else if (n.left == null && n.right == null) {
            mapa.put(n.data, s);
            return mapa;
        }
        else {
            mapa.putAll(calcularCodigos(n.left, s + "0"));
            mapa.putAll(calcularCodigos(n.right, s + "1"));
            return mapa;
        }
    }
    
    public static String codificar(String texto, Map<String,String> mapa) {
        StringBuilder retorno = new StringBuilder();
        String[] caracteres = texto.split("");
        for(String i : caracteres) {
            retorno.append(mapa.get(i));
        }
        return retorno.toString();
    }
    
    public static String decodificar(String texto, Map<String,String> mapa) {
        StringBuilder retorno = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        String[] codigos = texto.split("");
        Set<String> llaves = mapa.keySet();
        
        for(String i : codigos) {
            tmp.append(i);
            if (mapa.containsValue(tmp.toString())) {
                Iterator<String> it = llaves.iterator();
                while (tmp.length() != 0) {
                    String llave = it.next();
                    if (mapa.get(llave).equals(tmp.toString())) {
                        retorno.append(llave);
                        tmp = new StringBuilder();
                    }
                }
            }
        }
        return retorno.toString();
    }
    
}
