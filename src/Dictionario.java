import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionario
{
    public static void main(String[] args)
    {
        ArrayList<String> wordList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        File words = new File("C:\\Users\\bryce\\OneDrive\\Documents\\College\\Personal\\Programs\\src\\Words.txt");
        int points = 0;
        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(words));
            String line;
            int index = 0;

            //Importing the list of words from Words.txt
            while((line = bf.readLine()) != null)
            {
                wordList.add(line);
                index++;
            }
            bf.close();
        }
        catch(Exception e) //The pinnacle of laziness
        {
            e.printStackTrace();
        }

        System.out.println("Welcome to Dictionario! Try to guess one of the most used words in the English language.");
        System.out.println("Successfully guess all 100, and you win!");
        System.out.println("To exit the program, enter -1");
        System.out.println("Enter a word:");

        String input = in.next();

        while(!input.equals("-1"))
        {
            if(wordList.contains(input))
            {
                points++;
                wordList.remove(input);
                System.out.println("Correct! Points: " + points);
            }
            else
                System.out.println("Incorrect, Points: " + points);

            System.out.println("Enter a word:");
            input = in.next();
        }

        if(input.equals("-1"))
        {
            System.out.println("Words not guessed: ");

            for(int i = 0; i < wordList.size(); i++) {
                if(i % 10 == 0)
                    System.out.println();
                System.out.print(wordList.get(i) + ", ");

            }
        }

        System.exit(1);


    }
}
