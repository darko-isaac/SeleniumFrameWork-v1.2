package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class array1 {

    public static void main(String[] args){

        array1 arrayNew = new array1();

        ArrayList<int[]> numerosA= new ArrayList<>();
        numerosA.add(new int[] {23,23,25});
        numerosA.add(new int[] {35,355,35});
        numerosA.add(new int[] {23,23,23});
        numerosA.add(new int[] {23,54,45});

        ArrayList<Integer> resultado = new ArrayList<>();

        for(int[] ticket :numerosA){
           int result= arrayNew.validarTiket(ticket[0],ticket[1],ticket[2]);
                    resultado.add(result);
        }

        for(int result:resultado){
         System.out.println("el resultado es:"+result);

        }
    }
    public int validarTiket(int a,int b,int c){
        if (a == b && b == c) {
            return 20; // All numbers are the same
        } else if (a == b || a == c || b == c) {
            return 10; // Two numbers are the same
        } else {
            return 0; // All numbers are different
        }
    }

}
