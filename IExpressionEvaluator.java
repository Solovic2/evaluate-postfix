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
public interface IExpressionEvaluator {
    /**
     * covert infix to postfix
     * @param expression
     * @return string
     */
   public String infixToPostfix(String expression);
   /**
    * calculate equation of postfix
    * @param expression
    * @return 
    */
   public int evaluate(String expression); 
}
