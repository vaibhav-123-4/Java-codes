
import java.util.*;
 
public class Test {
     
    
 
    static Object Postfix(String exp){
    
        Stack<Object> stack = new Stack<>();
 
        for (int i = 0;i<exp.length(); i++) {
            char c = exp.charAt(i);
 
            if (Character.isDigit(c))
                stack.push(c - '0');
 
      
            else {
                Object val1 = stack.pop();
                Object val2 = stack.pop();
 
                switch (c) {
                case '+':
                    stack.push(val2 +"+" +val1);
                    break;
                case '-':
                    stack.push(val2 +"-" +val1);
                    break;
                case '/':
                    stack.push(val2 +"/" +val1);
                    break;
                case '*':
                    stack.push(val2 +"*" +val1);
                    break;
                }
            }
        }
        return stack.pop();
    }
 
    // Driver code
    public static void main(String[] args)
    {
        String exp = "12+34*-";
       
      
        System.out.println("postfix: "
                           + Postfix(exp));
    }
}
//code 2 below



import java.util.*;

public class test2{
    public static int prec(char x){

        if(x=='^'){   // highest prec
            return 2;
        }
        else if(x=='*' || x=='/'){
            return 1;                        // second highest prec
        }
        else if(x=='+' || x=='-'){
            // lowest prec

            return 0;
        }
        return -1; // not an operator
    }

    public static String InfixToPostfix(String str){

        Stack<Character>stk= new Stack<>();             // used for converting infix to postfix

        String ans="";                // string containing our final answer

        int n= str.length();

        for (int i = 0; i <n ; i++) {
            char x= str.charAt(i);

            if(x>='0' && x<='9'){
                ans+=x;
            }

            else if(x=='('){     // push directly in the stack
                stk.push('(');
            }
            else if(x==')'){

                while(!stk.isEmpty() && stk.peek()!='('){          // keep popping till opening bracket is found
                    ans+=stk.pop();
                }
                if(!stk.isEmpty()){
                    stk.pop();
                }

            }   
            else{

                while(!stk.isEmpty() && prec(stk.peek())>=prec(x)){    // remove all higher prec values
                    ans+=stk.pop();
                }
                stk.push(x);

            }
        }
        while(!stk.isEmpty()){
            ans+=stk.pop();
        }
        return ans;
    }
    public static String InfixToPrefix(String str){

        Stack<Character>stk= new Stack<>();             // used for converting infix to postfix

        String ans="";                // string containing our final answer

        int n= str.length();

        for (int i = n-1; i >=0 ; i--) {
            char x= str.charAt(i);

            if(x>='0' && x<='9'){
                ans+=x;
            }

            else if(x==')'){     // push directly in the stack
                stk.push(')');
            }
            else if(x=='('){

                while(!stk.isEmpty() && stk.peek()!=')'){          // keep popping till opening bracket is found
                    ans+=stk.pop();
                }
                if(!stk.isEmpty()){
                    stk.pop();
                }

            }
            else{

                while(!stk.isEmpty() && prec(stk.peek())>=prec(x)){    // remove all higher prec values
                    ans+=stk.pop();
                }
                stk.push(x);

            }
        }
        while(!stk.isEmpty()){
            ans+=stk.pop();
        }
        return ans;
    }
    public static void main(String[] args) {
        String str="1+2-(3*4)";
        System.out.println("Postfix expression is : "+ InfixToPostfix(str));
        System.out.println("Prefix expression is : "+ InfixToPrefix(str));
    }
}
