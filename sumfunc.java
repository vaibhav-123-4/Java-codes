import java.util.Scanner;

public class sumfunc {
    public static void main(String[] args) {
        sum();
        sum();
        sum();

    }
    static void sum(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enetr number 1:");
        int number1 = sc.nextInt();
        System.out.println("enter mumber2:");
        int number2 = sc.nextInt();
        System.out.println(number1+number2);

    }

}
