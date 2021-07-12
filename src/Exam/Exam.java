package Exam;

import java.util.HashMap;
import java.util.Map;

public class Exam
{
    /*
    *   This class represents an exam that contains numbered questions.
    */

    private final Map<Integer, Question> questionsMap;

    Exam()
    {
        questionsMap = new HashMap<>();
    }

    public Map<Integer, Question> getQuestionsMap()
    {
        return questionsMap;
    }

    public boolean inputQuestion(int questionNumber, Question question)
    {
        if(questionNumber < 0 || question == null) return false;
        questionsMap.put(questionNumber, question);
        return true;
    }

    public Question getQuestion(int questionNumber)
    {
        if (questionNumber < 0) return null;
        return questionsMap.get(questionNumber);
    }

    protected boolean removeQuestion(int questionNumber)
    {
        if(questionNumber < 0) return false;
        questionsMap.remove(questionNumber);
        return true;
    }
}
