import java.util.*;
import java.lang.*;
import java.io.*;

class trash
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       
       int min = 0 ;
       for(int i=0 ; i < t ; i += 1){
        int x = sc.nextInt();
        int y = sc.nextInt();
        int p = 0 ;
        if(x>y){
            min = y ;
        }
        else{
            min = x ;
        }
        // if (x <= y){
        //     System.out.println(0);
        // }
        for ( int j = 0 ; j < min ; j++){
                if (x>y){
                    x -= 2;
                    y -= 1;
                    p+=1;
                }
            else if (x<=y){
                // System.out.println(0);
                break;
            }
        }
        // System.out.println("syte,");

            System.out.println(p);
       }
	}
}