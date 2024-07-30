package org.example;
public class Calculadora {
    // The multiplicar method takes two parameters and returns their product
    public static int multiplicar(int num1, int num2) {
        int resultado;
        resultado =num1 * num2;
        return resultado;
    }


    public boolean isnull(int valor_resultado) {
        boolean resultado = true;
        if (valor_resultado != 0) {
            resultado = false;
        }
        return resultado;
    }
}





// Other methods and functionalities can be added as needed

