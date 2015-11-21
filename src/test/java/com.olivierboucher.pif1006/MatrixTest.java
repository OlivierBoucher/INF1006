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
    public void testAddShouldPass() throws Exception {
        Matrix a = new Matrix(new double[][]{
                {1, 2, 3}, {3, 2, 1}, {2, 1, 3}
        });
        Matrix b = new Matrix(new double[][]{
                {1, 2, 3}, {3, 2, 1}, {2, 1, 3}
        });
        Matrix c = a.add(b);
        Matrix r = new Matrix(new double[][]{
                {2, 4, 6}, {6, 4, 2}, {4, 2, 6}
        });
        for (int i = 0; i < c.getNumRows(); i++) {
            for (int j = 0; j < c.getNumColumns(); j++) {
                assertEquals(r.getElement(i, j), c.getElement(i, j), 0);
            }
        }
    }

    @Test
    public void testScalarProduct() throws Exception {
        Matrix a = new Matrix(new double[][]{
                {1, 2, 3}, {3, 2, 1}, {2, 1, 3}
        });
        Matrix b = a.scalarProduct(3);
        Matrix r = new Matrix(new double[][]{
                {3, 6, 9}, {9, 6, 3}, {6, 3, 9}
        });
        for (int i = 0; i < b.getNumRows(); i++) {
            for (int j = 0; j < b.getNumColumns(); j++) {
                assertEquals(r.getElement(i, j), b.getElement(i, j), 0);
            }
        }
    }

    @Test
    public void testMatrixMultiplication() throws Exception {
        Matrix a = new Matrix(new double[][]{
                {1, 2, 3}, {3, 2, 1}, {2, 1, 3}
        });

        Matrix b = new Matrix(new double[][]{
                {4, 5, 6}, {6, 5, 4}, {4, 6, 5}
        });

        Matrix c = a.matrixMultiplication(b);
        Matrix r = new Matrix(new double[][]{
                {28, 33, 29}, {28, 31, 31}, {26, 33, 31}
        });

        for (int i = 0; i < c.getNumRows(); i++) {
            for (int j = 0; j < c.getNumColumns(); j++) {
                assertEquals(r.getElement(i, j), c.getElement(i, j), 0);
            }
        }
    }

    @Test
    public void testGetTrace() throws Exception {
        Matrix a = new Matrix(new double[][]{
                {1, 2, 3},
                {3, 2, 1},
                {2, 1, 3}
        });
        double expected = 6.0;
        assertEquals(expected, a.getTrace(), 0);
    }

    @Test
    public void testGetDeterminant() throws Exception {
        Matrix a = new Matrix(new double[][]{
                {1, 2, 3},
                {3, 2, 1},
                {2, 1, 3}
        });
        double expected = -12;
        assertEquals(expected, a.getDeterminant(), 0);
    }

    @Test
    public void testGetSubmatrix() throws Exception {
        Matrix a = new Matrix(new double[][]{
                {1, 2, 3},
                {3, 2, 1},
                {2, 1, 3}
        });
        Matrix b = a.getSubmatrix(1, 1);
        Matrix c = new Matrix(new double[][]{
                {1, 3},
                {2, 3}
        });
        for (int i = 0; i < c.getNumRows(); i++) {
            for (int j = 0; j < c.getNumColumns(); j++) {
                assertEquals(c.getElement(i, j), b.getElement(i, j), 0);
            }
        }
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

        for (int i = 0; i < c.getNumRows(); i++) {
            for (int j = 0; j < c.getNumColumns(); j++) {
                assertEquals(r.getElement(i, j), c.getElement(i, j), 0);
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

        for (int i = 0; i < c.getNumRows(); i++) {
            for (int j = 0; j < c.getNumColumns(); j++) {
                assertEquals(r.getElement(i, j), c.getElement(i, j), 0);
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
                {1.0 / 3.0, 1.0 / 3.0, 0},
                {-(2.0 / 3.0), 1.0 / 3.0, 1},
                {1, -1, -1}
        });

        for (int i = 0; i < c.getNumRows(); i++) {
            for (int j = 0; j < c.getNumColumns(); j++) {
                assertEquals(r.getElement(i, j), c.getElement(i, j), 0);
            }
        }
    }

    @Test
    public void testIsSquaredShouldPass() throws Exception {
        Matrix a = new Matrix(new double[][]{
                {2, 1, 1},
                {1, -1, -1},
                {1, 2, 1}
        });
        assertEquals(true, a.isSquared());
    }

    @Test
    public void testIsSquaredShouldFail() throws Exception {
        Matrix a = new Matrix(new double[][]{
                {2, 1, 1},
                {1, -1, -1},
        });
        assertEquals(false, a.isSquared());
    }

    @Test
    public void testIsTriangularAnyShouldFail() throws Exception {
        Matrix a = new Matrix(new double[][]{
                {2, 1, 1},
                {1, -1, -1},
                {1, 2, 1}
        });
        assertEquals(false, a.isTriangular(Matrix.TriangleType.ANY, false));
    }

    @Test
    public void testIsTriangularAnyShouldSuccess() throws Exception {
        Matrix a = new Matrix(new double[][]{
                {2, 0, 0},
                {1, 1, 0},
                {1, 2, 1}
        });
        assertEquals(true, a.isTriangular(Matrix.TriangleType.ANY, false));
    }

    @Test
    public void testIsTriangularStrictAnyShouldSuccess() throws Exception {
        Matrix a = new Matrix(new double[][]{
                {0, 0, 0},
                {1, 0, 0},
                {1, 2, 0}
        });
        assertEquals(true, a.isTriangular(Matrix.TriangleType.ANY, true));

        Matrix b = new Matrix(new double[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        });
        assertEquals(true, b.isTriangular(Matrix.TriangleType.INFERIOR, true));
    }

    @Test
    public void testIsRegularShouldSuccess() throws Exception {
        Matrix a = new Matrix(new double[][]{
                {1, 2, 3},
                {3, 2, 1},
                {2, 1, 3}
        });
        assertEquals(true, a.isRegular());
    }

    @Test
    public void testIsRegularShouldFail() throws Exception {
        Matrix a = new Matrix(new double[][]{{1, 0, 3}, {3, 0, 1}, {2, 0, 3}});
        assertEquals(false, a.isRegular());
    }

    @Test
    public void testToString() throws Exception {

    }
}