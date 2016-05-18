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
        System.out.println("Enter a decimal integer to see its equivalent in base 2,"
                    + "\nbase 16 and base 8. Enter 0 to exit.");
        while(true){
            int number = 1;
            try{
                number = readInt();
            }catch (NumberFormatException e){
                System.out.println("Ce n'est pas un nombre.");
            }

            if(number != 0){
                String binaryNum = binaryConv(number, 2);
                String hexaNum = binaryConv(number, 16);
                String octalNum = binaryConv(number, 8);
                System.out.println("Binary: " + binaryNum +
                                   "\nHexadecimal: " + hexaNum + 
                                   "\nOctal: " + octalNum +
                                   "\nEnter a new number: ");
            }
            else{
                System.exit(0);
            }
        }
    }
    
    //Try to implement this with a while, then with recursion.
    public static String binaryConv(int number, int base){
        String binaryNum = "";
        int remainder = 0;
        char digit;
        while(number != 0){
            remainder = number % base;
            number /= base;
            if(base == 16){
                if(remainder == 15){
                    digit = 'F';
                }
                else if(remainder == 14){
                    digit = 'E';
                }
                else if(remainder == 13){
                    digit = 'D';
                }
                else if(remainder == 12){
                    digit = 'C';
                }
                else if(remainder == 11){
                    digit = 'B';
                }
                else if(remainder == 10){
                    digit = 'A';
                }
                else{
                    digit = (char)('0' + remainder);
                }
            }
            else{
                digit = (char)('0' + remainder);
            }
            binaryNum += digit;
        }
        
        //Reverse
        String temp = "";
        for(int i = binaryNum.length()-1; i >= 0; i--){
            temp += binaryNum.charAt(i);
        }
        return temp;
    }
    
    public static int hexaConv(int number){
        return 1;
    }
}
