package com.olivierboucher.pif1006;

/**
 * Created by olivier on 2015-11-06.
 */
public class Main {

    public static void main(String[] args) {
        double[][] innnerM = {
                {2, 3},
                {2, 4}
        };
        double[][] multiplyM = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}};
        Matrix m = null;
        try {
            m = new Matrix(innnerM);
            Matrix multiplyMatrix = new Matrix(multiplyM);
            m = m.matrixMultiplication(multiplyMatrix);
            System.out.print(m.toString());
        } catch (Matrix.MatrixException e) {
            System.out.println(e.getMessage());
        }

    }
}
