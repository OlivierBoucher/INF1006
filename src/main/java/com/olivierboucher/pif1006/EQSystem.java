package com.olivierboucher.pif1006;

import java.util.Arrays;

/**
 * Created by olivier on 2015-11-20.
 */
public class EQSystem {
    private Matrix matA;
    private Matrix matB;

    public EQSystem(Matrix squaredMat, Matrix varMat) throws SystemException {
        if(!squaredMat.isSquared()){
            throw new SystemException("Matrix A must be squared");
        }

        int n = squaredMat.getNumColumns();

        if(!(varMat.getNumColumns() == 1 && varMat.getNumRows() == n) &&
                !(varMat.getNumRows() == 1 && varMat.getNumColumns() == n)){
            throw new SystemException("Matrix B must be 1xn or nx1 where n is the size of Matrix A");
        }

        matA = squaredMat;

        if(varMat.getNumRows() == 1 && varMat.getNumColumns() == n){
            try {
                matB = varMat.getInversed();
            } catch (Matrix.MatrixException e) {
                throw new SystemException(e.getMessage());
            }
        }
        else {
            matB = varMat;
        }

    }

    public Matrix findXByCramer() {
        try {
            double d = matA.getDeterminant();

            if (d == 0) throw new Matrix.MatrixException("Determinant cannot be equal to zero");

            int n = matA.getNumColumns();
            Matrix m = new Matrix(n,1);
            double tmp;

            for(int i = 0; i < n; i++){
                for(int j =0 ; j < matA.getNumRows(); j++){
                    tmp = matB.getElement(j, 0);
                    matB.setElement(j, 0, matA.getElement(j, i));
                    matA.setElement(j, i, tmp);
                }
                m.setElement(i, 0, matA.getDeterminant());
                for(int j = 0 ; j < matA.getNumRows(); j++){
                    tmp = matB.getElement(j, 0);
                    matB.setElement(j, 0, matA.getElement(j, i));
                    matA.setElement(j, i, tmp);
                }
            }

            m.scalarProduct(1/d);
            return m;

        } catch (Matrix.MatrixException e) {
            return null;
        }
    }

    public Matrix findXByMatricialInversion() {
        try {
            double d = matA.getDeterminant();

            if (d == 0) throw new Matrix.MatrixException("Determinant cannot be equal to zero");

            Matrix a = matA.getCoMatrix();
            Matrix b = a.getTransposed();
            Matrix c = b.scalarProduct(1/d);
            Matrix r = c.matrixMultiplication(matB);

            return r;

        } catch (Matrix.MatrixException e) {
            return null;
        }
    }

    public Matrix findXByJacobi(double epsilon) {
       if(matA.isDominant()) {
           int n = matA.getNumRows();
           Matrix approximations = new Matrix(n, 1);
           Matrix previous = new Matrix(n, 1);

           while (true) {
               for (int i = 0; i < n; i++) {
                   double sum = matB.getElement(i, 0);

                   for (int j = 0; j < n; j++)
                       if (j != i)
                           sum -= matA.getElement(i, j) * previous.getElement(j, 0);

                   approximations.setElement(i, 0, (1 / matA.getElement(i, i) * sum));
               }

               boolean stop = true;
               for (int i = 0; i < n && stop; i++)
                   if (Math.abs(approximations.getElement(i, 0) - previous.getElement(i, 0)) > epsilon)
                       stop = false;

               if (stop) break;
               previous = approximations;
           }

           return approximations;
       }
       else {
           System.out.println("Matrix must be dominant");
           return null;
       }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < matA.getNumRows(); i++){
            for(int j = 0; j < matA.getNumColumns(); j++){

                sb.append( j == 0 ? matA.getElement(i, j) : Math.abs(matA.getElement(i, j)));
                char var = (char)(97 + j);
                sb.append(var);
                if(j != matA.getNumColumns() - 1){

                    sb.append(matA.getElement(i, j+1) > 0 ? " + " : " - ");
                }
            }
            sb.append(" = ");
            sb.append(matB.getElement(i, 0));
            sb.append(";\n");
        }

        return sb.toString();
    }

    public static class SystemException extends Exception {
        public SystemException(String msg) {
            super(msg);
        }
    }
}
