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
        Matrix m = null;
        try {
            m = new Matrix(innnerM);
            m = m.add(m);
            System.out.println(m.getDeterminant());
            System.out.print(m.toString());
        } catch (Matrix.MatrixException e) {
            System.out.println(e.getMessage());
        }

    }
}
