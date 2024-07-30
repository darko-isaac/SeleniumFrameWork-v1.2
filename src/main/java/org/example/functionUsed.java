package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class functionUsed {

    public static void main(String[] args){
        String c = "asdf3434tertbc".substring(5,9);
        System.out.println(c);

        List<Integer> values = new ArrayList<>();

        // agregar valores a mi lista
        values.add(23);
        values.add(2344);
        values.add(5545);
        values.add(33);
        values.add(2);

        System.out.println("Original list: " + values);
        Collections.sort(values);
        //values.sort(Comparator.naturalOrder());
        System.out.println("Sorted list: " + values);


    }


}
