package Exam;

import File.AnswersFile;
import File.QuestionsParamFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public class ExaminationBoard
{
    private final int numberOfExams;
    private final int numberOfQuestions;
    private final Exam exam;
    private final LinkedList<Student> students;

    public ExaminationBoard(String resultsFileName, String questionsParamFileName)
    {
        AnswersFile results = new AnswersFile(resultsFileName);
        QuestionsParamFile questionParam = new QuestionsParamFile(questionsParamFileName);

        exam = new Exam();
        students = new LinkedList<>();
        numberOfExams = results.getNumberOfStudents();
        numberOfQuestions = questionParam.getNumberOfQuestions();

        try
        {
            registerStudents(results);
            inputQuestionInExam(questionParam);
        }
        catch (IOException e)
        {
            System.out.println("Questions or Students register was not possible.");
        }
    }

    private void registerStudents(AnswersFile results) throws IOException
    {
        BufferedReader reader = results.allLinesReader();
        for (int i = 0; i < 5; i++) reader.readLine();

        for (int i = 0; i < numberOfExams; i++)
        {
            String line = reader.readLine();
            Student newStudent = new Student();
            newStudent.answer = new int[numberOfQuestions];
            String[] questionAnswers = line.split(" ");

            for (int j = 0; j < numberOfQuestions; j++)
            {
                newStudent.answer[j] = Integer.parseInt(questionAnswers[j + 1]);
            }

            students.add(newStudent);
        }
    }

    private void inputQuestionInExam(QuestionsParamFile questionParam) throws IOException
    {
        BufferedReader reader = questionParam.allLinesReader();
        for (int i = 0; i < 3; i++) reader.readLine();

        for (int i = 0; i < numberOfQuestions; i++)
        {
            String line = reader.readLine();
            String[] parameters = line.split(" ");
            double paramA = Double.parseDouble(parameters[1]);
            double paramB = Double.parseDouble(parameters[2]);
            double paramC = Double.parseDouble(parameters[3]);
            Question newQuestion = new Question(paramA, paramB, paramC);

            exam.inputQuestion(i + 1, newQuestion);
        }
    }

    public Exam getExam()
    {
        return exam;
    }

    public LinkedList<Student> getStudents()
    {
        return students;
    }

    public int getNumberOfExams()
    {
        return numberOfExams;
    }

    public int getNumberOfQuestions()
    {
        return numberOfQuestions;
    }
}
