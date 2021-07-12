package File;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuestionsParamFile extends DataFile
{
    /*
    *
    *   This class get all parameters of all questions
    *   of a exam in a text file, in addition to methods
    *   such as to get the number of questions.
    *
    *   The text file questionData.txt was provided by
    *   Professor Valdinei Silva.
    *
    */

    public QuestionsParamFile(String fileName)
    {
        super(fileName);
    }

    public int getNumberOfQuestions()
    {
        File datafile = getDataFile();

        try
        {
            Scanner reader = new Scanner(datafile);
            reader.nextLine();
            reader.next();
            reader.next();

            return reader.nextInt();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("The file was not found.");
        }

        return -1;
    }
}
