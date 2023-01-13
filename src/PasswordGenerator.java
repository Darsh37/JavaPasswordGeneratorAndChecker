import com.sun.jdi.event.MethodExitEvent;

import java.util.Scanner;

public class PasswordGenerator {
        String stringUppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String stringNumber = "0123456789";
        String stringLowerCase = "abcdefghijklmnopqrstuvwxyz";
        String stringSymbol = "@!#$%^&";

        void decisionString(){
            boolean includeUpperCase = false;
            boolean includeLowerCase = false;
            boolean includeNumber= false;
            boolean includeSymbol= false;
            int pwdLen=0;

            userInput (includeUpperCase,includeLowerCase,includeNumber,includeSymbol,pwdLen);
        }


    void userInput(boolean includeUpperCase, boolean includeLowerCase,boolean includeNumber, boolean includeSymbol, int pwdLen ){

        Scanner sc =new Scanner(System.in);

        String inputFromUser= "";

        System.out.println("Welcome to Password generator Program");

        System.out.println("Please answer the following Question in yes or no");

        System.out.println("Do you want add A-Z uppercase letters in your password");
        inputFromUser = sc.nextLine();
        if(isInclude(inputFromUser)) includeUpperCase = true;

        System.out.println("Do you want add a-z lowercase letters in your password");
        inputFromUser = sc.nextLine();
        if(isInclude(inputFromUser)) includeLowerCase =true;

        System.out.println("Do you want add Numbers in your password");
        inputFromUser = sc.nextLine();
        if(isInclude(inputFromUser)) includeNumber= true;

        System.out.println("Do you want add Symbols in your password");
        inputFromUser = sc.nextLine();
       if(isInclude(inputFromUser)) includeSymbol =true;

        try {
            System.out.println("what is the length of your password");
            pwdLen =sc.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isInclude(String inputFromUser) {
        if (inputFromUser.equalsIgnoreCase("yes")) {
            return true;
        } else {
            if (!inputFromUser.equalsIgnoreCase("no")) {
                System.out.println("Error");;
            }
            return false;
        }
    }
    private String getPoolString(boolean includeUpperCase, boolean includeLowerCase, boolean includeNumber, boolean includeSymbol) {

            String pool ="";
        if (includeUpperCase) pool = pool + stringUppercase;
        if (includeLowerCase) pool = pool + stringLowerCase;
        if (includeNumber) pool = pool + stringNumber;
        if (includeSymbol) pool = pool + stringSymbol;
        System.out.println(pool);
        return pool;
    }



    String generatePassword(boolean includeUpperCase,boolean includeLowerCase,boolean includeNumber,boolean includeSymbol,int pwdLen) {
        char[] password = new char[pwdLen];

        String pool = getPoolString(includeUpperCase,includeLowerCase,includeNumber,includeSymbol);

        for (int i = 0; i < pwdLen; i++) {
            int index = (int) (pool.length() * Math.random());
            password[i] = pool.charAt(index);
        }

        System.out.println("Password"+password);
        return new String(password);

        //return String.valueOf(password);
//        StringBuilder pwd = new StringBuilder();
//        for (char a : password) {
//            pwd.append(a);
//        }
//        return pwd.toString();
    }

    void result(){
        System.out.println("password"+generatePassword());
    }

    public static void main(String args[]) {

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        System.out.println("password"+);



    }



}



/****
 * 1. take input from user. create new method and call it from main.
 * 2. remove alphabet Strings from global space and keep it separately.
 * 3. randomize alphabet, number and symbols also before taking input to generate function.
 * 4. implement different methods for randomization.
 *
 *
 *
 */
