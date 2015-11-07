package com.olivierboucher.pif1006;

/**
 * Created by olivier on 2015-11-06.
 */
public class Matrix {


    private double[][] matrix;

    public Matrix(double[][] matrix) throws MatrixException {
        this.matrix = matrix;

        for (int i = 0; i < matrix.length; i++) {
            if (i < matrix.length - 1) {
                if (matrix[i].length != matrix[i + 1].length) {
                    throw new MatrixException("Invalid array dimensions for a matrix");
                }
            }
        }
    }

    public int getNumRows() {
        return matrix.length;
    }

    public int getNumColumns() {
        return matrix[0].length;
    }

    public Matrix(int size) {
        this.matrix = new double[size][size];
    }

    public Matrix(int line, int column) {
        this.matrix = new double[line][column];
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public double getElement(int line, int column) {
        return matrix[line][column];
    }

    public void setElement(int line, int column, double value) {
        matrix[line][column] = value;
    }

    public double[] getLine(int line) {
        return matrix[line];
    }

    public double[] getColumn(int column) {
        double[] returnColumn = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            returnColumn[i] = matrix[column][i];
        }
        return returnColumn;
    }

    public Matrix add(Matrix matrix) throws MatrixException {
        if (this.getLine(0).length != matrix.getLine(0).length || this.getColumn(0).length != matrix.getColumn(0).length) {
            throw new MatrixException("Matrix must be of the same size");
        }
        try {
            Matrix newMatrix = new Matrix(new double[this.matrix.length][this.getLine(0).length]);
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[0].length; j++) {
                    newMatrix.setElement(i, j, this.getElement(i, j) + matrix.getElement(i, j));
                }
            }
            return newMatrix;
        } catch (Exception e) {
           return null;
        }
    }

    public Matrix scalarProduct(double scalar) {
        double[][] innerMatrix = this.matrix;
        for(int i = 0; i < innerMatrix.length; i++) {
            for(int j = 0; j < innerMatrix[i].length; j++) {
                innerMatrix[i][j] = innerMatrix[i][j] * scalar;
            }
        }
        try {
            return new Matrix(innerMatrix);
        } catch (MatrixException e) {
           return null;
        }
    }

    public Matrix matrixMultiplication(Matrix matrix) throws MatrixException {
        if (this.getLine(0).length != matrix.getMatrix().length) {
            return null;
        }
        Matrix newMatrix = new Matrix(new double[this.getMatrix().length][matrix.getMatrix()[0].length]);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < matrix.getMatrix()[0].length; j++) {
                for (int k = 0; k < this.matrix[0].length; k++) {
                    newMatrix.setElement(i, j, newMatrix.getElement(i, j) + this.getElement(i, k) * matrix.getElement(k, j));
                }
            }
        }
        return newMatrix;
    }

    public double getTrace() throws MatrixException {
        if(this.isSquared()) {
            double trace = 0;
            for(int i = 0; i < this.matrix.length; i++) {
                for(int j = 0; j < this.matrix[i].length; j++) {
                    if(i == j) {
                        trace += this.matrix[i][j];
                    }
                }
            }
            return trace;
        }

        throw new MatrixException("Matrix must be squared");
    }

    public double getDeterminant() throws MatrixException {
        if (!this.isSquared())
            throw new MatrixException("Matrix need to be square.");
        if (this.matrix.length == 1) {
            return this.getElement(0, 0);
        }
        if (matrix.length == 2) {
            return (this.getElement(0, 0) * this.getElement(1, 1)) - ( this.getElement(0, 1) * this.getElement(1, 0));
        }
        double sum = 0.0;
        for (int i = 0; i < matrix.length; i++) {
            int sign = i % 2 == 0 ? 1 : -1;
            sum += sign * this.getElement(0, i) * getSubmatrix(0, i).getDeterminant();
        }
        return sum;
    }

    public Matrix getSubmatrix(int line, int col) throws MatrixException {
        try {
            Matrix m = new Matrix(getNumColumns() - 1, getNumColumns() - 1);

            int r = -1;

            for(int i = 0; i < getNumRows(); i++) {
                if(i == line)
                    continue;

                r++;
                int c = -1;

                for(int j =0; j < getNumColumns() ; j++) {
                    if(j == col)
                        continue;

                    m.setElement(r, ++c, getElement(i, j));
                }
            }

            return m;
        }
        catch(IndexOutOfBoundsException e) {
            throw new MatrixException("Invalid line or column parameter");
        }
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
        return matrix.length == 1 || matrix.length == matrix[1].length;
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
        for (int i = 0; i < matrix.length; i++) {
            if (i == 0) {
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
            } else {
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
