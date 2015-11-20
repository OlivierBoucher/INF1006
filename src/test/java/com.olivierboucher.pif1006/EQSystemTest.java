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
        assertEquals(-2, r.getElement(0,1), 0);
        assertEquals(3, r.getElement(0,2), 0);
    }

    @Test
    public void testFindXByMatricialInversion() throws Exception {
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
        Matrix r = s.findXByMatricialInversion();

        assertEquals(1, r.getElement(0,0), 0);
        assertEquals(-2, r.getElement(0,1), 0);
        assertEquals(3, r.getElement(0,2), 0);
    }

    @Test
    public void testFindXByJacobi() throws Exception {

    }
}