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
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Enter a decimal integer to see its equivalent in base 2,"
                    + "\nbase 16 and base 8. Enter 0 to exit.");
        while(true){
            int number = 1;
            boolean neg = false;
            boolean error = false;
            try{
                number = readInt();
            }catch (NumberFormatException e){ //bool?
                System.out.println("Error: not a number.");
                error = true;
            }

            if(!error && number != 0){
                if(number < 0){
                    number *= -1;
                    neg = true;
                }
                String binaryNum = conversion(number, 2);
                String hexaNum = conversion(number, 16);
                String octalNum = conversion(number, 8);
                
                if(neg){
                    binaryNum = binNegative(binaryNum);
                }
                System.out.println("Binary: " + binaryNum +
                                   "\nHexadecimal: " + hexaNum + 
                                   "\nOctal: " + octalNum +
                                   "\nEnter a new number: ");
            }
            else if(!error){
                System.exit(0);
            }
        }
    }
    
    //Try to implement this with a while, then with recursion.
    public static String conversion(int number, int base){
        String temp = "";
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
            temp += digit;
        }
        
        //Reverse
        String convertedNum = "";
        for(int i = temp.length()-1; i >= 0; i--){
            convertedNum += temp.charAt(i);
        }
        return convertedNum;
    }
    
    public static String binNegative(String posBin){
        String negBin = "";
        
        if(posBin.length() != 16){
            String temp1 = "";
            for(int i = 0; i < 16; i++){
                if(posBin.length() + i < 16){
                    temp1 += '0';
                }
                else{
                    break;
                }
            }
            
            for(int i = 0; i < posBin.length(); i++){
                temp1 += posBin.charAt(i);
            }
            
            posBin = temp1;
        }
        
        for(int i = 0; i < posBin.length(); i++){
            if(posBin.charAt(i) == '1'){
                negBin += 0;
            }
            else{
                negBin += 1;
            }
        }
        
        if(negBin.charAt(negBin.length()-1) == '0'){
            String temp2 = "";
            for(int i = 0; i < negBin.length()-1; i++){
                temp2 += negBin.charAt(i);
            }
            temp2 += '1';
            negBin = temp2;
        }
        else{
            String temp3 = "";
            int index = 0;
            for(int i = negBin.length()-1; i >= 0; i--){
                if(negBin.charAt(i) == '0'){
                    index = i;
                    break;
                }
            }
            
            for(int i = 0; i < negBin.length() - 1; i++){
                if(i == index){
                    temp3 += '1';
                    break;
                }
                else{
                    temp3 += negBin.charAt(i);
                }
                System.out.println("Temp: " + temp3);
            }
            for(int i = index +1; i < negBin.length(); i++){
                temp3 += '0';
            }
            negBin = temp3;
        }
        
        return negBin;
    }
}
