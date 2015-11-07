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
        double[][] triangularSupM = {
                {1,2,3},
                {0,4,5},
                {0,0,6}
        };
        Matrix m;
        Matrix triangular;
        try {
            m = new Matrix(innnerM);
            System.out.print(m.getDeterminant());
            triangular = new Matrix(triangularSupM);
            System.out.println(triangular.isTriangular(Matrix.TriangleType.SUPERIOR,false));
            System.out.println(triangular.getInversed());

        } catch (Matrix.MatrixException e) {
            System.out.println(e.getMessage());
        }

    }
}
