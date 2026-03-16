package org.practica02.Pilas;

import java.util.Arrays;

public class PilaChar {
    private char[] datos;
    private int index;
    private int limite;

    public PilaChar(int limite){
        this.datos= new char[limite];
        this.limite  = limite;
        this.index = -1;
    }

    /*
    "({[]})"  → válido
    "({[}])"  → inválido
    "((("     → inválido
     */

    public void push(char elemento){
        this.index++;
        this.datos[this.index] = elemento;
    }

    public char peek(){
        return this.datos[this.index];
    }

    public char pop(){
        char tmp = peek();
        index--;
        return tmp;
    }

    public boolean estaVacio(){
        return this.index == -1;
    }

    public void imprimir(){
        System.out.println(Arrays.toString(this.datos));
    }

    public boolean validar(String cadena){
        for (int i = 0 ; i < cadena.length(); i++){
            char elemento = cadena.charAt(i);
            if (elemento == '(' || elemento == '[' || elemento == '{' ){
                push(elemento);
            }else{
                if (estaVacio()){ throw new IllegalArgumentException("Error: lista vacia");}

                char eleTop = peek();
                if ( ! ((eleTop == '(' && elemento == ')')
                        || (eleTop == '{' && elemento == '}')
                        || (eleTop == '[' && elemento == ']'))
                ){
                    return false;
                }else{
                    pop();
                }
            }
        }
        return estaVacio();
    }

    public String palindromo(String cadena){
        for (int i = 0; i < cadena.length(); i++){
            char element = cadena.charAt(i);
            push(element);
        }
        //String nuevaPalabra = "";
        char [] nuevaPalabra = new char[cadena.length()];
        for (int i = 0; i < cadena.length(); i++) {
            char actual = pop();
            nuevaPalabra[i] = actual;
        }
        return new String(nuevaPalabra);
    }

}
