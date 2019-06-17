

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {


    public static void main(String[] args) {

        //need to get input from the user

        //eg 5x5(1,3)(4,4) should return ENNNDEEEENNNND

        System.out.println(Constants.QUESTION.getDescription());
        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();

        //remove whitespace
        userInput = userInput.replaceAll("\\s","");

        int[][] grid = createGrid(userInput);

        if(grid != null){

            //input was 6x7(1,2)
            System.out.println("Number of columns: " + grid.length); //this returns 6
            System.out.println("Number of rows: " + grid[0].length);//this returns 7

            List<Point> points = createPoints(userInput);

            if(points.size() > 0){
                //we have a point -- assuming 1 parcel per location
                Courier courier = new Courier(points.size(), 0 ,0);
                String result = courier.deliveries(points);

                //deliveries should now be complete
                System.out.println("All deliveries are complete!");
                System.out.println(result);
            }
        }


    }


    public static int[][] createGrid(String input) {
        int gridX;
        int gridY;

        //minimum size of a valid input would be 8 characters eg. 5x5(1,3)
        if (input == null || input.length() < 8) {
            System.out.println(Constants.INVALID_INSRUCTIONS.getDescription());
        }
        else {

            //convert String to Array
            String[] myArray = input.split("");

            if (myArray[1].toLowerCase().equals("x")) {

                try {
                    gridX = Integer.parseInt(myArray[0]);
                    gridY = Integer.parseInt(myArray[2]);

                    if (gridX < 1 || gridY < 1) {
                        System.out.println(Constants.INVALID_INSRUCTIONS.getDescription());
                        return null;
                    }
                    int[][] grid = new int[gridX][gridY];

                    return grid;

                } catch (Exception e) {
                    System.out.println(Constants.INVALID_INSRUCTIONS.getDescription());
                }

            } else {
                System.out.println(Constants.INVALID_INSRUCTIONS.getDescription());
            }
        }

        return null;
    }




    public static List<Point> createPoints(String input) {

        List<Point> points = new ArrayList<>();

        //remove the first 3 characters from input
        String updatedInput = input.substring(3);

        //get the length - should be divisible by 5,

        System.out.println(updatedInput);

        //check input size is divisible by 5 - if not then input would be invalid as each coordinate should have 5 characters
        if(updatedInput.length() % 5 == 0) {

            int numberOfCoordinates = updatedInput.length() / 5;

            //create strings of each 5 characters and add each String to a list
            List<String> coordinates = new ArrayList<>();

            //not working - only taking the first 5 -- will need to sort the coordinates
            for (int i = 0; i < numberOfCoordinates; i++) {
                coordinates.add(updatedInput.substring(0, 5));
                updatedInput = updatedInput.substring(5); //remove the first 5 coordinates
            }


            for (String c : coordinates) {

                //need to remove the (,) from c, check length remaining of c is 2 otherwise input is invalid
                c = c.replace("(", "");
                c = c.replace(",", "");
                c = c.replace(")", "");
                if(c.length() == 2){
                    String[] myArray = c.split("");

                    try{
                        int x = Integer.parseInt(myArray[0]);
                        int y = Integer.parseInt(myArray[1]);

                        //create the point
                        Point point = new Point(x, y);
                        //add points to arraylist
                        points.add(point);

                    }catch(Exception e){
                        System.out.println(Constants.INVALID_INSRUCTIONS);
                    }
                }
            }
        }
        return points;
    }

}
