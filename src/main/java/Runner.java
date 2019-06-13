

import java.util.Scanner;

public class Runner {


    public static void main(String[] args) {

        //need to get input from the user

        //eg 5x5(1,3)(4,4) should return EENNDEEENDDDD

        System.out.println(Constants.QUESTION.getDescription());
        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();

        //remove whitespace
        userInput = userInput.replaceAll("\\s","");

        int[][] grid = createGrid(userInput);

       // List<Point> points = createPoints(userInput);

    }


    public static int[][] createGrid(String input){
        int gridX;
        int gridY;

        //minimum size of a valid input would be 8 characters eg. 5x5(1,3)
        if(input == null || input.length() < 8) {
            System.out.println(Constants.INVALID_INSRUCTIONS.getDescription());
        }
        else {

            //convert String to Array
            String[] myArray = input.split("");

            if(myArray[1].toLowerCase().equals("x")){

                try{
                    gridX = Integer.parseInt(myArray[0]);
                    gridY = Integer.parseInt(myArray[2]);
                    int[][] grid = new int[gridX][gridY];

                    return grid;

                }catch(Exception e){
                    System.out.println(Constants.INVALID_INSRUCTIONS.getDescription());
                }

            }else{
                System.out.println(Constants.INVALID_INSRUCTIONS.getDescription());
            }

            return null;
        }



    }
}
