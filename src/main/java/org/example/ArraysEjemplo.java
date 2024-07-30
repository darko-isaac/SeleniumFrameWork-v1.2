package org.example;

import java.util.ArrayList;

public class ArraysEjemplo {
    public static void main(String[] args) {
        ArraysEjemplo greenTicket = new ArraysEjemplo();

        ArrayList<int[]> tickets = new ArrayList<>();
        tickets.add(new int[] {10, 5, 5});
        tickets.add(new int[] {22, 22, 4});
        tickets.add(new int[] {345, 66, 86});

        // Calculate results for each ticket and store them
        ArrayList<Integer> results = new ArrayList<>();
        for (int[] ticket : tickets) {
            int result = greenTicket.vaalidarGreeenticket(ticket[0], ticket[1], ticket[2]);
            results.add(result);
        }

        // Display results (for demonstration purposes)
        for (int result : results) {
            System.out.println("Result: " + result);
        }
    }

    public int vaalidarGreeenticket(int a, int b, int c) {
        if (a == b && b == c) {
            return 20; // All numbers are the same
        } else if (a == b || a == c || b == c) {
            return 10; // Two numbers are the same
        } else {
            return 0; // All numbers are different
        }
    }
}
