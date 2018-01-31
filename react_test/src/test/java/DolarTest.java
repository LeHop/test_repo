/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hoppe
 */
public class DolarTest {
    
    public DolarTest() {
    }

    /**
     * Test of times method, of class Dolar.
     */
    @Test
    public void testTimes() {
        Dolar five = new Dolar(5);
        Dolar product = five.times(2);
        assertEquals(10, product.getAmount());
        product = five.times(3);
        assertEquals(15, product.getAmount());
    }
    
    @Test
    public void testEquality(){
        assertTrue(new Dolar(5).equals(new Dolar(5)));
        assertFalse(new Dolar(5).equals(new Dolar(6)));
    }
    
}
