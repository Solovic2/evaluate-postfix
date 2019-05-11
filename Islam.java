/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eg.edu.alexu.csd.datastructure.stack;

import static java.lang.Math.pow;

/**
 *
 * @author Momen
 */

public class Islam implements IExpressionEvaluator{
 /**
  * switches it use to give the operator an parenthesis
  * @param a
  * @return the parenthesis
  */
    public int switchs(String a){
int s=0;
    switch(a.charAt(0)){
        case '+': s=1;
                  break;
        case '-': s=1;
                  break;
        case '*': s=4;
                  break;
        case '/': s=4;
                  break;
        case '%': s=4;
                  break;
        case '^': s=5;
                  break;
    }
return s;
}
/**
 * it doing calculation between numbers by using a suitable operation c
 * @param a
 * @param b
 * @param c
 * @return The calculation of a and b
 */
    public int sw(int a,int b,char c){
    int calc=0;
    switch(c){
        case '+': calc= a+b;
            break;
        case '-': calc= a-b;
            break;    
        case '*': calc= a*b;
            break;
        case '/': if(b!=0){
                    calc= a/b;
                }else if(b==0){
                    System.out.println("Cannot Divide By zero >> return -1");
                    return -10;
                    }
            break;                     
        case '%': calc= a%b;
            break;
        case '^': calc= (int) pow(a,b);
            break;  
    }
    return calc;
}
int va=0;
/**
 * It convert from infix to postfix
 * @param expression
 * @return 
 */
    public String infixToPostfix(String expression){
        Stack op=new Stack();
       String postfix="";
       String expression_spaces="";
       for(int k=0; k<expression.length();k++){
           if(expression.charAt(k)!=' ') 
           expression_spaces+=""+expression.charAt(k);
       } 
       for(int i=0;i<expression_spaces.length();i++){      
            if(Character.isDigit(expression_spaces.charAt(i))){
            postfix+= expression_spaces.charAt(i);
          }else{
               if(expression_spaces.charAt(i)=='('){
                    va++;
                  op.push(""+expression_spaces.charAt(i));
               }else if(expression_spaces.charAt(i)==')'  ){
                   if(op.IsEmpty())
                       break;
                    String q="";
                    q= (String) op.peak();
                    
                    while( q == null ? (""+'(') != null : !q.equals(""+'(') ){
                        postfix+=" ";
                        postfix+=op.pop();
                        
                        if(op.IsEmpty()){
                            break;
                        }
                        q=  (String) op.peak();
                    }
                        if(q == null ? (""+'(') == null : q.equals(""+'(')){
                            q= (String) op.pop();
                            if(op.IsEmpty()==false){
                            q=  (String) op.peak();
                            }else{
                                break;
                            }
                            
                        }
                       
                    
                        if(i==expression_spaces.length()-1 && op.IsEmpty()==false){
                             postfix+=" ";
                        }                   
               }else if(op.IsEmpty()==true || op.peak()=="("){  
                  postfix+=" "; 
                  op.push(""+expression_spaces.charAt(i));
               }else {
                    postfix+=" "; 
                    String s1= (String) op.peak();
                    op.push(""+expression_spaces.charAt(i));
                    String s2=(String) op.pop();
                    int x1=switchs(s2);
                    int x2=switchs(s1);
                    if(x1>x2){
                       op.push(""+expression_spaces.charAt(i));
                    }if(x2>=x1 && x2 !=7){
                        postfix+=op.pop();
                        postfix+=" ";
                        if(op.IsEmpty()==false){
                            for(int f=0;f<op.size();f++){
                                if(op.peak()!="("){
                                    String s3=(String) op.peak();
                                    op.push(""+expression_spaces.charAt(i));
                                    String s4=(String) op.pop();
                                    int x3=switchs(s4);
                                    int x4=switchs(s3);
                                    if(x4>=x3){
                                        postfix+=op.pop();
                                        postfix+=" ";
                                    }
                               }
                           }
                       }
                        op.push(""+expression_spaces.charAt(i));
                   }
               }
          }
        }  
     int f=op.size();
     if(Character.isDigit(postfix.charAt(postfix.length()-1)))
        postfix+=" "; 
        for(int j=0;j<f; j++){
            if(op.peak()!="("){
            postfix+=op.pop();
              if(j<f-1)
             postfix+=" ";
            }
        } 
        return postfix;
    }
   /**
    * Calculate the equation
    * if there are '(' the function ignore it and don't use it 
    * @param expression
    * @return 
    */
    public int evaluate(String expression){
        Stack v=new Stack();
        int sum=0;
        int z=0;
        String s="";
        for(int i=0;i<expression.length();i++){
            if(Character.isWhitespace(expression.charAt(i))==true){
                 if(s!="")
                  v.push(s);
                if(Character.isDigit(expression.charAt(i+1))==false){                  
                    if(v.size()!=1){
                      String t;
                      String t2;
                      t=(String) v.pop();
                      t2=(String) v.pop();
                      int x=Integer.parseInt(t);
                      int x1=Integer.parseInt(t2);  
                      z=sw(x1,x,expression.charAt(i+1));
                      String str=Integer.toString(z);
                      v.push(str);
                      if(x==0 && expression.charAt(i+1)=='/'){
                          return -1;
                      }
                    }if(v.size()==1 ){
                        sum=z;
                    }
                }                
              s="";
            }else if(Character.isDigit(expression.charAt(i))==true){                   
                   s+=expression.charAt(i);
            }
        }
        return sum;
    }
}
