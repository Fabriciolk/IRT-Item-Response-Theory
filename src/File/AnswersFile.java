package File;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AnswersFile extends DataFile
{
    /*
    *
    *   This class get all answers of all students on
    *   a exam in a text file, in addition to contain
    *   methods such as to get the number of students
    *   and the number of questions.
    *
    *   The text file studentsAnswFile.txt was provided by
    *   Professor Valdinei Silva.
    *
    */

    public AnswersFile(String fileName)
    {
        super(fileName);
    }

    public int getNumberOfStudents()
    {
        File datafile = getDataFile();

        try
        {
            Scanner reader = new Scanner(datafile);
            for (int i = 0; i < 3; i++) reader.nextLine();
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

    public int getNumberOfQuestions()
    {
        File datafile = getDataFile();

        try
        {
            Scanner reader = new Scanner(datafile);
            for (int i = 0; i < 4; i++) reader.nextLine();
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
