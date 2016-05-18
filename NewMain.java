//Maybe TODO: Negative numbers?
package nc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewMain {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int readInt(){
        try{
            return Integer.parseInt(br.readLine());
        }catch (IOException e){
            System.out.println("Ce n'est pas un nombre.");
            return 0;
            //Eventually, put a boolean?
        }
    }
    
    public static void main(String[] args) {
        int number;
        System.out.println("Enter a decimal integer to see its equivalent in base 2,"
                + "\nbase 16 and base 8. Enter 0 to exit.");
        number = readInt();
        if(number != 0){
            int binaryNum = binaryConv(number);
            //int hexaNum = hexaConv(number);
            //int octalNum = octalConv(number);
            System.out.println("Binary: " + binaryNum);
        }
        else{
            number = -1;
        }
        //System.exit(0);
    }
    
    //Try to implement this with a while, then with recursion.
    public static int binaryConv(int number){
        String binaryNum = "";
        int remainder = 0;
        while(number != 0){
            remainder = number % 2;
            number /= 2;
            binaryNum += remainder;
        }
        
        //Reverse
        String temp = "";
        for(int i = binaryNum.length()-1; i >= 0; i--){
            temp += binaryNum.charAt(i);
        }
        return Integer.parseInt(binaryNum);
    }
}
