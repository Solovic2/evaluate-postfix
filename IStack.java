/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eg.edu.alexu.csd.datastructure.stack;

/**
 *
 * @author Momen
 */
public interface IStack {
/**
 * push into stack
 * @param s 
 */
   public void push(String s); 
  /**
   * pop from stack
   * @return string 
   */
   public Object pop(); 
   /**
    * peak the top of stack without removing it
    * @return 
    */
   public Object peak();
  /**
   * check Empty stack or not
   * @return string 
   */
   public boolean IsEmpty();
  /**
   * check size of stack
   * @return integer 
   */
   public int size();
}
