package org.practica02.Ordenamiento;

public class Ordenamiento {
    //{1,9,6,8,6,2,1}
    public static int[] quickSort(int[] arr, int inicio, int tamaño){
        if (inicio >= tamaño-1) return arr;

        int pivot = arr[tamaño-1];
        int ind = inicio - 1;
        int tmp = 0;

        for (int i = inicio; i < tamaño ; i++)
        {
            if(arr[i] < pivot){
                tmp = arr[ind+1];
                arr[ind+1] = arr[i];
                arr[i] = tmp;
                ind++;
            }

            if (i == tamaño-1){
                tmp= arr[ind+1];
                arr[ind+1] = arr[i];
                arr[i] = tmp;
                ind++;
            }

        }

        quickSort(arr, inicio, ind); //menores
        quickSort(arr,ind+1, tamaño); //mayores


        return arr;
    }

    //{1,9,6,8,6,2,1}
    public static int[] bubleSort(int[] arr){
        int tmp = 0;
        for (int i = 0; i < arr.length-1; i++){
            for (int j = 0; j < arr.length-1-i; j++){
                if (arr[j] > arr[j+1] ){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        return arr;
    }

    public static int[] bubleSortR(int[] arr, int tamaño){
        if (tamaño == 1) return arr;
        int tmp = 0;
        for (int j = 0; j < tamaño-1; j++){
            if (arr[j] > arr[j+1] ){
                tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
            }
        }

        bubleSortR(arr, tamaño-1);
        return arr;
    }
}
