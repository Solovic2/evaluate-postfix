package eg.edu.alexu.csd.datastructure.stack;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Momen
 */
public class Stack implements IStack {
    LinkedList ob =new LinkedList();
    public int top =ob.getlength()-1;
    public void push(String s){
        top++;
        ob.add(s);
    }
    public String pop(){
       if(ob.isEmpty()==false){
            String s=ob.get(top);
            ob.remove(top);
            top--;
            return s;
        }
       else {
           return "Exception";
       }
    }
    public String peak(){
       return ob.get(top);
    }
    public boolean IsEmpty(){
        if(ob.isEmpty()==true){
            return true;
        }else{
            return false;
        }
    }
    public int size(){
        return ob.getlength();
    }
}
