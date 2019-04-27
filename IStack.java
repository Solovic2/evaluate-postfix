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
   public void push(String s); 
   public String pop(); 
   public String peak();
   public boolean IsEmpty();
   public int size();
}
