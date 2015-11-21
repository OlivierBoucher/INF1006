package com.olivierboucher.pif1006;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by olivier on 2015-11-20.
 */
public class EQSystemTest {

    @Test
    public void testFindXByCramer() throws Exception {
        Matrix matA = new Matrix(new double[][]{
                {2, 1, 1},
                {1, -1, -1},
                {1, 2, 1}
        });
        Matrix matB = new Matrix(new double[][]{
                {3},
                {0},
                {0}
        });

        EQSystem s = new EQSystem(matA, matB);
        Matrix r = s.findXByCramer();

        assertEquals(1, r.getElement(0,0), 0);
        assertEquals(-2, r.getElement(1,0), 0);
        assertEquals(3, r.getElement(2,0), 0);
    }

    @Test
    public void testFindXByMatricialInversion() throws Exception {
        Matrix matA = new Matrix(new double[][]{
                {3, -2},
                {-5, 4}
        });
        Matrix matB = new Matrix(new double[][]{
                {6},
                {8}
        });

        EQSystem s = new EQSystem(matA, matB);
        Matrix r = s.findXByMatricialInversion();

        assertEquals(20, r.getElement(0,0), 0);
        assertEquals(27, r.getElement(1,0), 0);
    }

    @Test
    public void testFindXByJacobi() throws Exception {
        Matrix matA = new Matrix(new double[][]{
                {5, -2, 3},
                {-3, 9, 1},
                {2, -1, -7}
        });
        Matrix matB = new Matrix(new double[][]{
                {-1},
                {2},
                {3}
        });

        EQSystem s = new EQSystem(matA, matB);
        Matrix r = s.findXByJacobi(1e-5);
        Matrix x = s.findXByCramer();

        assertEquals(x.getElement(0,0), r.getElement(0,0), 0.05);
        assertEquals(x.getElement(1,0), r.getElement(1,0), 0.05);
        assertEquals(x.getElement(2,0), r.getElement(2,0), 0.05);
    }
}