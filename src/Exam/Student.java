package Exam;

public class Student
{
    protected int[] answer;
    public double ability;

    Student() {}

    public int[] getAnswer()
    {
        return answer;
    }

    public double getAbility()
    {
        return ability;
    }

    @Override
    public String toString() {
        String studentInfo = "Student{answer= ";

        for (int j : answer) studentInfo = studentInfo.concat(j + " ");

        studentInfo = studentInfo.concat("; ability=" + ability + "}");

        return studentInfo;
    }
}
