/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eg.edu.alexu.csd.datastructure.stack;

import java.util.Scanner;

/**
 *
 * @author Momen
 */
public class StackApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Please Enter The Equation ( Without Space!!!!! )");
        Scanner sc=new Scanner (System.in);
        String input=sc.next();
        Stack p=new Stack();
        Islam d=new Islam();
        String x= d.infixToPostfix(input);
      int y=d.evaluate(x);
      System.out.println("The Evaluation is : "+y);
    }
}
