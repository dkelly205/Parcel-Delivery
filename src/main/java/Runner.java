
import com.sun.tools.javac.util.StringUtils;

import java.util.Scanner;

public class Runner {


    public static void main(String[] args) {

        //need to get input from the user

        //eg 5x5(1,3)(4,4) should return EENNDEEENDDDD

        System.out.println(Constants.QUESTION);
        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();

        //remove whitespace
        userInput = userInput.replaceAll("\\s","");

        createGrid(userInput);



    }


    public static void createGrid(String input){

        if(input == null || input.equals("")){
            System.out.println(Constants.NO_INSRUCTIONS);
        }

        //convert input to array
        //char[] stringToCharArray = input.toCharArray();


    }
}
