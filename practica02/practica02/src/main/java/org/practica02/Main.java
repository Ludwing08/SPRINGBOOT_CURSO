package org.practica02;


import org.practica02.Pilas.PilaChar;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        int [] array = {488,97,64,3,5,79,7,1};
        int [] arrSort = Ordenamiento.quickSort(array,5,array.length);
        int [] arrBuble= Ordenamiento.bubleSort(array);
        int [] arrBubleR= Ordenamiento.bubleSortR(array, array.length);


        System.out.println("QuickSort: " + Arrays.toString(arrSort));
        System.out.println("BubleSort: " + Arrays.toString(arrBuble));
        System.out.println("BubleSort Recursive: " + Arrays.toString(arrBubleR));
        */
/*
        PilaEntero pilaEntero1 = new PilaEntero();
        pilaEntero1.push(5);
        pilaEntero1.push(6);
        pilaEntero1.push(7);
        pilaEntero1.push(9);
        pilaEntero1.push(10);

        pilaEntero1.imprimirElementos();
        System.out.println( "Peek: " + pilaEntero1.peek());
        System.out.println(pilaEntero1.getTop());
        System.out.println( "Pop: " + pilaEntero1.pop());
        System.out.println(pilaEntero1.getTop());
        pilaEntero1.imprimirElementos();
        */

        PilaChar pilaChar = new PilaChar(6);
        //System.out.println(pilaChar.validar("({[]})"));
        // pilaChar.imprimir();

        String palabra = "DAMIAN";
        PilaChar palindromo = new PilaChar(palabra.length());
        System.out.println(palindromo.palindromo(palabra));
    }
}