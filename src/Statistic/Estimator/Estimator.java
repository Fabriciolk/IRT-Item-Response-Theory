package Statistic.Estimator;

import Exam.Question;
import Exam.Student;
import Statistic.Functions.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Estimator
{
    /*
    *   This class estimate the ability of a individual student, based
    *   on all questions and its parameters and student's answers for
    *   those. For that, was used the ln-likelihood approach that consist
    *   in summation of all derivatives of ln[f(x)], where f(x) is a
    *   Item Characteristic Curve of a question.
    */

    private final Map<Integer, Question> questionMap;
    private final Student student;
    private final Set<Function> ICCFuncSet = new HashSet<>();
    private final Set<Function> DxLnICCFunctionSet = new HashSet<>();
    private final Set<Function> NotICCFuncSet = new HashSet<>();
    private final Set<Function> DxLnNotICCFunctionSet = new HashSet<>();

    public Estimator(Map<Integer, Question> questionMap, Student student)
    {
        this.questionMap = questionMap;
        this.student = student;
        setICCFuncSets();
    }

    /*
    *   This method take all required functions to calculate the
    *   student's ability based on answers.
    */

    private void setICCFuncSets()
    {
        for (int i = 0; i < student.getAnswer().length; i++)
        {
            Question question = questionMap.get(i + 1);

            if (student.getAnswer()[i] == 1)
            {
                Function ICCFunc = new ICCFunction(question.getA(), question.getB(), question.getC());
                Function DxICCFunc = new DxLnICCFunction(question.getA(), question.getB(), question.getC());
                ICCFuncSet.add(ICCFunc);
                DxLnICCFunctionSet.add(DxICCFunc);
            }
            else
            {
                Function NotICCFunc = new NotICCFunction(question.getA(), question.getB(), question.getC());
                Function DxNotICCFunc = new DxLnNotICCFunction(question.getA(), question.getB(), question.getC());
                NotICCFuncSet.add(NotICCFunc);
                DxLnNotICCFunctionSet.add(DxNotICCFunc);
            }
        }
    }

    /*
    *   The method returns the value of likelihood function on a point (theta)
    */

    public double likelihood(double theta)
    {
        double value = 1;
        Iterator<Function> itrICC = ICCFuncSet.iterator();
        Iterator<Function> itrNotICC = NotICCFuncSet.iterator();

        while (itrICC.hasNext())
        {
            value = value * itrICC.next().getFunctionValue(theta);
        }

        while (itrNotICC.hasNext())
        {
            value = value * itrNotICC.next().getFunctionValue(theta);
        }

        return value;
    }

    /*
     *   The method returns the value of ln-likelihood function on a point (theta)
    */

    public double lnLikelihood(double theta)
    {
        double value = 0;
        Iterator<Function> itrICC = ICCFuncSet.iterator();
        Iterator<Function> itrNotICC = NotICCFuncSet.iterator();

        while (itrICC.hasNext())
        {
            value += Math.log(itrICC.next().getFunctionValue(theta)) / Math.log(Math.exp(1));
        }

        while (itrNotICC.hasNext())
        {
            value += Math.log(itrNotICC.next().getFunctionValue(theta)) / Math.log(Math.exp(1));
        }

        return value;
    }

    public Student getStudent()
    {
        return student;
    }
}
