package org.practica02.Pilas;

import java.util.Arrays;

public class PilaEntero {
    private int[] datos;

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    private int top ;    //indice del maximo elemento
    private int capacidad = 5;  //cuantos elementos maximo

    public PilaEntero() {
        datos = new int[capacidad];
        this.top = -1;
    }



    public void push(int valor){

        this.top++;
        this.datos[this.top] = valor;

    }

    public int pop(){
        int tmp = this.datos[top];
        top--;
        return tmp;
    }

    public int peek(){
        return this.datos[top];
    }

    public boolean estaVacia(){
        return this.top == -1;
    }

    public void imprimirElementos(){
        System.out.println(Arrays.toString(this.datos));
    }
}
