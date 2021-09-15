package org.iesfm.accessEjer.repaso;

import java.util.Scanner;

public class Methods {
    // <MODIF_ACCESA> <STATIC> <RETURN_TYPE> <NOMBRE>(<PARAMETROS>)
    public static int suma (int n1 , int n2){
        return n1 + n2;
    }

    private  static Scanner scan = new Scanner(System.in);

    public static int pideNumero(){
        System.out.println("Introduce numero");
        int n = scan.nextInt();
        scan.nextLine();
        return n;
    }

    public static  int[] pideArray(){

        System.out.println("tamaño del numero");
        int size = scan.nextInt();
        scan.nextLine();

        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i]= pideNumero();
        }

        return array;
    }

    public static void main(String[] args) {

        int suma = suma(pideNumero(), pideNumero());
        System.out.println(suma);

        int[] array = pideArray();

        for (int num : array) {
            System.out.println(num);
        }

    }
}
