package katapotter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jyrki
 */


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShoppingBasketTest {
    
    ShoppingBasket basket; 
    
    @Before
    public void setUp() {
         basket = new ShoppingBasket();
    }
    
    @Test
    public void testBasics1() {
        
        //  assert_equal(0, price([]))
        int[] bookArray = null;
        Assert.assertEquals(0, basket.price(bookArray), 0);
    }
    
    @Test       
    public void testBasics2() {
        
        //assert_equal(8, price([0]))
        int[] bookArray = {0};
        Assert.assertEquals(8, basket.price(bookArray), 0);
        
    }
    
    @Test       
    public void testBasics3() {
          
        //assert_equal(8, price([1]))
        int[] bookArray = {1};
        Assert.assertEquals(8, basket.price(bookArray), 0);
        
    }
    
    @Test       
    public void testBasics4() {
        
        //assert_equal(8, price([2]))
        int[] bookArray = {2};
        Assert.assertEquals(8, basket.price(bookArray), 0);
        
    }
    
     @Test       
    public void testBasics5() {
        
        //assert_equal(8, price([3]))
        int[] bookArray = {3};
        Assert.assertEquals(8, basket.price(bookArray), 0);
        
    }
    
    @Test       
    public void testBasics6() {
        
        //assert_equal(8, price([4]))
        int[] bookArray = {4};
        Assert.assertEquals(8, basket.price(bookArray), 0);
        
    }
    
    @Test       
    public void testBasics7() {
        
        //assert_equal(8 * 2, price([0, 0]))
        int[] bookArray = {0,0};
        Assert.assertEquals(8 * 2, basket.price(bookArray), 0);
        
    }
    
    @Test       
    public void testBasics8() {
        
        //assert_equal(8 * 3, price([1, 1, 1]))
        int[] bookArray = {1,1,1};
        Assert.assertEquals(8 * 3, basket.price(bookArray), 0);
        
    }
    
    @Test       
    public void testSimpleDiscounts1() {
        
        //assert_equal(8 * 2 * 0.95, price([0, 1]))
        int[] bookArray = {0,1};
        Assert.assertEquals(8 * 2 * 0.95, basket.price(bookArray), 0);
        
    }
    
    @Test       
    public void testSimpleDiscounts2() {
                
        //assert_equal(8 * 3 * 0.9, price([0, 2, 4]))
        int[] bookArray = {0,2,4};
        Assert.assertEquals(8 * 3 * 0.9, basket.price(bookArray), 0);
        
    }
    
    @Test       
    public void testSimpleDiscounts3() {
      
        //assert_equal(8 * 3 * 0.9, price([0, 2, 4]))
        int[] bookArray = {0, 1, 2, 4};
        Assert.assertEquals(8 * 4 * 0.8, basket.price(bookArray), 0);  
    }
    
    @Test       
    public void testSimpleDiscounts4() {   
        
        // assert_equal(8 * 5 * 0.75, price([0, 1, 2, 3, 4]))
        int[] bookArray = {0, 1, 2, 3, 4};
        Assert.assertEquals(8 * 5 * 0.75, basket.price(bookArray), 0);  
    }
    
    @Test       
    public void testSeveralDiscounts1() { 

        //  assert_equal(8 + (8 * 2 * 0.95), price([0, 0, 1]))
        int[] bookArray = {0, 0, 1};
        Assert.assertEquals(8 + (8 * 2 * 0.95), basket.price(bookArray), 0);  
    }
    
     @Test       
    public void testSeveralDiscounts2() { 

        //  assert_equal(2 * (8 * 2 * 0.95), price([0, 0, 1, 1]))
        int[] bookArray = {0, 0, 1, 1};
        Assert.assertEquals(2 * (8 * 2 * 0.95), basket.price(bookArray), 0);  
    }
    
    @Test       
    public void testSeveralDiscounts3() { 
        
        // assert_equal((8 * 4 * 0.8) + (8 * 2 * 0.95), price([0, 0, 1, 2, 2, 3]))
        int[] bookArray = {0, 0, 1, 2, 2, 3};
        Assert.assertEquals((8 * 4 * 0.8) + (8 * 2 * 0.95), basket.price(bookArray), 0);  
    }
    
    @Test       
    public void testSeveralDiscounts4() { 
        
        //  assert_equal(8 + (8 * 5 * 0.75), price([0, 1, 1, 2, 3, 4]))
        int[] bookArray = {0, 1, 1, 2, 3, 4};
        Assert.assertEquals(8 + (8 * 5 * 0.75), basket.price(bookArray), 0);  
    }
    
    @Test       
    public void testEdgeCases1() { 
        
        //  assert_equal(2 * (8 * 4 * 0.8), price([0, 0, 1, 1, 2, 2, 3, 4]))
        int[] bookArray = {0, 0, 1, 1, 2, 2, 3, 4};
        Assert.assertEquals(2 * (8 * 4 * 0.8), basket.price(bookArray), 0);  
    }
    
    @Test       
    public void testEdgeCases2() { 
        
        /* assert_equal(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8), 
                                                price([0, 0, 0, 0, 0, 
                                                       1, 1, 1, 1, 1, 
                                                       2, 2, 2, 2, 
                                                       3, 3, 3, 3, 3, 
                                                       4, 4, 4, 4])) */
        int[] bookArray =                             {0, 0, 0, 0, 0, 
                                                       1, 1, 1, 1, 1, 
                                                       2, 2, 2, 2, 
                                                       3, 3, 3, 3, 3, 
                                                       4, 4, 4, 4};
        Assert.assertEquals(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8), basket.price(bookArray), 0);  
    }
    
    @Test       
    public void testEdgeCasesExtra() { 
        
        //  assert_equal(2 * (8 * 4 * 0.8) + (8 * 3 * 0.9), 
        //  price([0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 4]))
        int[] bookArray = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 4};
        Assert.assertEquals(2 * (8 * 4 * 0.8) + (8 * 3 * 0.9), basket.price(bookArray), 0);  
    }
}
