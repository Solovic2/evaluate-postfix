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
public int switchs(char a){
int s=0;
    switch(a){
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
    public String infixToPostfix(String expression){
        Stack op=new Stack();
       String postfix="";
        for(int i=0;i<expression.length();i++){      
            if(Character.isDigit(expression.charAt(i))){
            postfix+= expression.charAt(i);
          }else{
               if(expression.charAt(i)=='('){
                    va++;
                  op.push(""+expression.charAt(i));
               }else if(expression.charAt(i)==')'){
                    char q;
                   if(op.peak().charAt(0)=='('){
                      q= op.pop().charAt(0);
                   }else{
                        postfix+=" ";
                        postfix+=op.pop().charAt(0);

                        }
                        if(i==expression.length()-1 && op.IsEmpty()==false){
                             postfix+=" ";
                        }                   
               }else if(op.IsEmpty()==true || op.peak().charAt(0)=='('){  
                  postfix+=" "; 
                  op.push(""+expression.charAt(i));
               }else {
                    postfix+=" "; 
                    char s1=op.peak().charAt(0);
                    op.push(""+expression.charAt(i));
                    char s2=op.pop().charAt(0);
                    int x1=switchs(s2);
                    int x2=switchs(s1);
                    if(x1>x2){
                       op.push(""+expression.charAt(i));
                    }if(x2>=x1 && x2 !=7){
                        postfix+=op.pop().charAt(0);
                        postfix+=" ";
                        if(op.IsEmpty()==false){
                            for(int f=0;f<op.size();f++){
                                if(op.peak().charAt(0)!='('){
                                    char s3=op.peak().charAt(0);
                                    op.push(""+expression.charAt(i));
                                    char s4=op.pop().charAt(0);
                                    int x3=switchs(s4);
                                    int x4=switchs(s3);
                                    if(x4>=x3){
                                        postfix+=op.pop().charAt(0);
                                        postfix+=" ";
                                    }
                               }
                           }
                       }
                        op.push(""+expression.charAt(i));
                   }
               }
          }
        }  
     int f=op.size();
     if(Character.isDigit(postfix.charAt(postfix.length()-1)))
        postfix+=" "; 
        for(int j=0;j<f; j++){
            postfix+=op.pop().charAt(0);
              if(j<f-1)
             postfix+=" ";
        } 
        return postfix;
    }
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
                      t=v.pop();
                      t2=v.pop();
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
