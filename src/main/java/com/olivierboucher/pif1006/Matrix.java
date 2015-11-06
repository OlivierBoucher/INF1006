package com.olivierboucher.pif1006;

/**
 * Created by olivier on 2015-11-06.
 */
public class Matrix {
    double[][] matrix;

    public Matrix(double[][] matrix) throws MatrixException {
        this.matrix = matrix;

        for(int i = 0; i < matrix.length; i++) {
            if(i < matrix.length -1) {
                if(matrix[i].length != matrix[i+1].length){
                    //TODO(Olivier): Wrong array passed
                    throw new MatrixException("Invalid array dimensions for a matrix");
                }
            }
        }
    }

    public double getElement(int line, int column) {
        return 0;
    }

    public void setElement(int line, int column, double value) {

    }

    public double[] getLine(int line) {
        return null;
    }

    public double[] getColumn(int column) {
        return null;
    }

    public Matrix add(Matrix matrix) {
        return null;
    }

    public Matrix scalarProduct(Matrix matrix) {
        return null;
    }

    public Matrix matrixMultiplication(Matrix matrix) {
        return null;
    }

    public double getTrace() {
        return 0;
    }

    public double getDeterminant() {
        return 0;
    }

    public Matrix getTransposed() {
        return null;
    }

    public Matrix getCoMatrix() {
        return null;
    }

    public Matrix getInversed() {
        return null;
    }

    public Boolean isSquared() {
        return false;
    }

    public Boolean isTriangular() {
        return false;
    }

    public Boolean isRegular() {
        return false;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < matrix.length; i++) {
            if(i == 0) {
                sb.append("{\n");
            }
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0) {
                    sb.append("\t[");
                }

                sb.append(matrix[i][j]);

                if (j == matrix[i].length - 1) {
                    sb.append("]");
                } else {
                    sb.append(", ");
                }
            }

            if (i == matrix.length - 1) {
                sb.append("\n}");
            }
            else {
                sb.append(",\n");
            }
        }
        return sb.toString();
    }

    public static class MatrixException extends Exception {
        public MatrixException(String msg) {
            super(msg);
        }
    }
}
