package Exam;

public class Question
{
    /*
    *
    *   This class represents each question of a exam, whose
    *   parameters a, b, c means the item discrimination parameter,
    *   difficult parameter and the parameter that represent the
    *   probability to get a question randomly, respectively.
    *
    */

    private final char answer;
    private final double a;
    private final double b;
    private final double c;

    public Question(double a, double b, double c, char answer)
    {
        this.answer = answer;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    Question(double a, double b, double c)
    {
        this.answer = '?';
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Question{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public char getAnswer()
    {
        return answer;
    }

    public double getA()
    {
        return a;
    }

    public double getB()
    {
        return b;
    }

    public double getC()
    {
        return c;
    }
}
