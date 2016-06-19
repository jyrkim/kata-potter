/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katapotter;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;


/**
 *
 * @author Jyrki
 */
public class ShoppingBasket {
    
    public ShoppingBasket() {
        
   
    }
    
    /**
    * Calculates discounted price for set of books as described in KataPotter
    * problem description
    * @param  shoppingBasket  int array that has books for shopping basket
    * @return discounted double price of shopping basket
    * @see <a href="http://codingdojo.org/cgi-bin/index.pl?KataPotter">KataPotter</a>
    */
    public double price(int[] shoppingBasket) {
        
        // array for book count values 
        // countOfBooksArray[0] --> for book1 count, 
        // countOfBooksArray[1] --> for book2 count and so on..
        // {book1, book2, book3, book4, book5}
        int[] countOfBooksArray = {0, 0, 0, 0, 0};
        
        //empty basket
        if (shoppingBasket == null)
            return 0;
        
        //if only one book, no discount
        if (shoppingBasket.length == 1)
             return 8;

        //go through shopping basket 
        //to look for number of different books
        for (int book : shoppingBasket){
            
            countOfBooksArray[book] += 1;
            
            /* // same thing as above, but with more code
            switch (book) {
                case 0:  countOfBooksArray[0] += 1;
                         break;
                case 1:  countOfBooksArray[1] += 1;
                         break;
                case 2:  countOfBooksArray[2] += 1;
                         break;
                case 3:  countOfBooksArray[3] += 1;
                         break;
                case 4:  countOfBooksArray[4] += 1;
                         break;
            }  
            */
        }
        
        //the largest quantity of one type of book
        int maxCount = 0;
        
        for (int bookCount : countOfBooksArray){ 
            
            if (bookCount > maxCount)
                maxCount = bookCount;
        }
        
        //arrayMatrix is two dimensional array to hold different type of books
        //and the occurrences of each book 
        //it has 5 "rows" 
        //and the number of "columns" is same as maxCount
        //for example following shopping basket: [0, 0, 1, 2, 2, 3]
        //has arrayMatrix like: { {0, 0}, 
        //                        {1,-1},
        //                        {2, 2}, 
        //                        {3,-1}, 
        //                        {-1,-1} }
        // -1 values are for no book/null book
        int[][] arrayMatrix = new int[5][];
        
        for (int rowIndex = 0; rowIndex < arrayMatrix.length; rowIndex++) 
        {
            //intialize "column" array for this row
            arrayMatrix[rowIndex] = new int[maxCount];
            
            //adjust book count to array index for comparison
            //for example 3 same books [0,0,0] have last index position 2 (= 3 - 1) 
            int bookCountIndex = countOfBooksArray[rowIndex] - 1;
            
            //initialize inner array (columns) for one type of book
            for (int colunmIndex = 0; colunmIndex < maxCount; colunmIndex++) 
            {  
                //if j <= bookCountIndex
                //then book exists at that index position
                if (colunmIndex <= bookCountIndex) {
                    arrayMatrix[rowIndex][colunmIndex] = rowIndex; 
                } else {
                    arrayMatrix[rowIndex][colunmIndex] = -1; //set -1 value if no book
                }         
            }
        }
        
        //total discounted sum of all books in shopping basket
        double totalSum = 0;
        
        //boolean value that is only used (true)
        //for special case of set of 5 and set of 3
        boolean previousColumn5 = false; 
        
        //calculate discounted value of books
        //colunm by column using arrayMatrix
        for (int colunmIndex = 0; colunmIndex < maxCount; colunmIndex++) 
        {  
            double sumOfColumn = 0;
            
            double sumOfNextColumn = 0;
            
            //go through all rows in one column
            for (int rowIndex = 0; rowIndex < arrayMatrix.length; rowIndex++) 
            {
                if (arrayMatrix[rowIndex][colunmIndex] > -1) {          
                    sumOfColumn += 1;   
                }
                
                //next column index
                int nextColumnIndex = maxCount -1;
                
                 //check next column if there's one
                if ( colunmIndex < nextColumnIndex) {
                    
                    //if next column has book in that index position add 1
                    if (arrayMatrix[rowIndex][colunmIndex + 1] > -1) { 
                        sumOfNextColumn += 1;   
                    }
                }
            }
            
            //check for special case 5 and 3
            if ( (sumOfColumn == 5)  && (sumOfNextColumn == 3) )  {
                
                previousColumn5 = true;
                
                //count using two sets of four books instead of one set of 5 and 3
                totalSum += (4 * 8 * 0.8) + (4 * 8 * 0.8);
                
            } else if (sumOfColumn == 5)  {       
                totalSum += (5 * 8 * 0.75);
            }
            else if (sumOfColumn == 4)  {              
                totalSum += (4 * 8 * 0.8); 
            }
            else if (sumOfColumn == 3)  { 
                //if special case 5 and 3 skip
                //it's already been added during previous round
                if (!previousColumn5)
                    totalSum += (3 * 8 * 0.90); 
                else // unset special case
                    previousColumn5 = false;
            } 
            else if (sumOfColumn == 2)  {              
                totalSum += (2 * 8 * 0.95); 
            }
            else if (sumOfColumn == 1)  {              
                totalSum += 8; 
            }
        }

        return totalSum;
    }
    
}
