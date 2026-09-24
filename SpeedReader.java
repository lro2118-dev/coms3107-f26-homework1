/**
 * Program to implement RSVP speed reader using StdDraw library.
 *
 * This assignment originally created by Peter-Michael Osera at University of Pennsylvania.
 * 
 * @author Chris Murphy
 */

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;



public class SpeedReader {

    /*
    This method is responsible for updating the text in the window for the speed reader.
    You will need to change the parameters as you complete this part of the assignment.
     */
    public static void show(String file, int wordsPerMin) {

        Scanner reader;

        try {
            File textFile = new File(file);
            reader = new Scanner(textFile);
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
            return;
        }

        setup();

        int wait = getWait(wordsPerMin);
       

       while (reader.hasNext() == true) { 

            waitForMouse();

            String word = reader.next();

            drawWord(word);

            // KEEP the same basic display steps from the starter
            StdDraw.show();

            // CHANGE 500 to our calculated wait
            StdDraw.pause(wait);

            // KEEP this
            StdDraw.clear();

        }

        reader.close();

    }

   private static int getWait(int wordsPerMin) {

        int wait = 60000 / wordsPerMin;

        return wait;
    }


    private static void waitForMouse() {

        while (StdDraw.isMousePressed() == false) {
            StdDraw.pause(10);
        }
    }


    private static String getMiddleLetter(String word) {

        int middle = word.length() / 2;

        char letter = word.charAt(middle);

        String middleLetter = String.valueOf(letter);

        return middleLetter;
    }


    private static double getWordX(String word) {

        double center = 50;
        double letterWidth = 7.5;

        double x = center;

        boolean even = word.length() % 2 == 0;

        if (even == true) {
            x = center - (letterWidth / 2);
        }

        return x;
    }


    private static void drawWord(String word) {

        double centerX = 50;
        double centerY = 50;

        String middleLetter = getMiddleLetter(word);

        double wordX = getWordX(word);

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(wordX, centerY, word);

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.text(centerX, centerY, middleLetter);
    }





    private static void setup() {
        // this creates a window of 800x600 pixels
        StdDraw.setCanvasSize(800, 400);

        // this sets the scale of the x- and y-axis to be from 0 to 100
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);

        // this enables animation so that things don't appear jittery
        StdDraw.enableDoubleBuffering();

        // this sets the drawing color to black
        StdDraw.setPenColor(StdDraw.BLACK);

        // this sets the text font to be fixed-width
        StdDraw.setFont(new java.awt.Font("COURIER", java.awt.Font.BOLD, 100));
    }


    public static void main(String[] args) {
         boolean correctInputs = args.length == 2;

    if (correctInputs == false) {
        System.out.println("Please specify the file name and wpm");
        return;
    }

    String file = args[0];

    int wordsPerMin;

    try {
        wordsPerMin = Integer.parseInt(args[1]);
    } catch (NumberFormatException e) {
        System.out.println("Please specify a positive wpm");
        return;
    }

    boolean positiveWpm = wordsPerMin > 0;

    if (positiveWpm == false) {
        System.out.println("Please specify a positive wpm");
        return;
    }

    show(file, wordsPerMin);
    
    }
    
}
