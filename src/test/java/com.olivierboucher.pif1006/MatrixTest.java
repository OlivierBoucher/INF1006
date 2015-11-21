package com.olivierboucher.pif1006;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by olivier on 2015-11-07.
 */
public class MatrixTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetNumRows() throws Exception {

    }

    @Test
    public void testGetNumColumns() throws Exception {

    }

    @Test
    public void testGetMatrix() throws Exception {

    }

    @Test
    public void testGetElement() throws Exception {

    }

    @Test
    public void testSetElement() throws Exception {

    }

    @Test
    public void testGetLine() throws Exception {

    }

    @Test
    public void testGetColumn() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testScalarProduct() throws Exception {

    }

    @Test
    public void testMatrixMultiplication() throws Exception {
        Matrix a = new Matrix(new double[][]{
                {1,2,3},{3,2,1},{2,1,3}
        });

        Matrix b = new Matrix(new double[][]{
                {4,5,6},{6,5,4},{4,6,5}
        });

        Matrix c = a.matrixMultiplication(b);
        Matrix r = new Matrix(new double[][]{
                {28, 33, 29}, {28, 31, 31}, {26, 33, 31}
        });

        for(int i = 0; i< c.getNumRows(); i++){
            for(int j = 0; j< c.getNumColumns(); j++){
                assertEquals(r.getElement(i,j), c.getElement(i, j), 0);
            }
        }
    }

    @Test
    public void testGetTrace() throws Exception {

    }

    @Test
    public void testGetDeterminant() throws Exception {

    }

    @Test
    public void testGetSubmatrix() throws Exception {

    }

    @Test
    public void testGetTransposed() throws Exception {
        Matrix a = new Matrix(new double[][]{
                {1, 2, 3},
                {3, 2, 1},
                {2, 1, 3}
        });

        Matrix c = a.getTransposed();
        Matrix r = new Matrix(new double[][]{
                {1, 3, 2},
                {2, 2, 1},
                {3, 1, 3}
        });

        for(int i = 0; i< c.getNumRows(); i++){
            for(int j = 0; j< c.getNumColumns(); j++){
                assertEquals(r.getElement(i,j), c.getElement(i, j), 0);
            }
        }
    }

    @Test
    public void testGetCoMatrix() throws Exception {
        Matrix a = new Matrix(new double[][]{
                {1, 2, 3},
                {4, 5, 6},
                {5, 4, 3}
        });

        Matrix c = a.getCoMatrix();
        Matrix r = new Matrix(new double[][]{
                {-9, 18, -9},
                {6, -12, 6},
                {-3, 6, -3}
        });

        for(int i = 0; i< c.getNumRows(); i++){
            for(int j = 0; j< c.getNumColumns(); j++){
                assertEquals(r.getElement(i,j), c.getElement(i, j), 0);
            }
        }
    }

    @Test
    public void testGetInversed() throws Exception {
        Matrix a = new Matrix(new double[][]{
                {2, 1, 1},
                {1, -1, -1},
                {1, 2, 1}
        });

        Matrix c = a.getInversed();
        Matrix r = new Matrix(new double[][]{
                {1.0/3.0, 1.0/3.0, 0},
                {-(2.0/3.0), 1.0/3.0, 1},
                {1, -1, -1}
        });

        for(int i = 0; i< c.getNumRows(); i++){
            for(int j = 0; j< c.getNumColumns(); j++){
                assertEquals(r.getElement(i,j), c.getElement(i, j), 0);
            }
        }
    }

    @Test
    public void testIsSquared() throws Exception {

    }

    @Test
    public void testIsTriangular() throws Exception {

    }

    @Test
    public void testIsRegular() throws Exception {

    }

    @Test
    public void testToString() throws Exception {

    }
}