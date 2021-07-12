import Exam.ExaminationBoard;
import Exam.Student;
import Graph.GraphDraw;
import Graph.Image;
import Statistic.Estimator.Estimator;

import java.util.Iterator;

public class IRT
{
    /*
    *   This program calculates an estimate of all student's ability that
    *   realized a exam, in addition to provide the minimum and maximum
    *   ability between them.
    *
    *   The calculation was done using the ln-likelihood approach that consist
    *   in a summation of all ln[f(x)] functions, where f(x) is the
    *   Item Characteristic Curve of a question.
    *
    *   Each curve contain three parameters and represents the probability
    *   to a student with an specific ability get the question.
    */

    static double thetaRange = -5;
    static double precision = 0.001;
    static double thetaMax;
    static double thetaMin;

    public static void main(String[] args)
    {
        ExaminationBoard examBoard = new ExaminationBoard("src\\File\\" + args[0], "src\\File\\" + args[1]);
        Iterator<Student> iterator = examBoard.getStudents().iterator();

        int student = 1;
        // This loop estimates all abilities of all students
        while (iterator.hasNext())
        {
            Image img = new Image(700, 800);
            GraphDraw g = new GraphDraw(new int[] {50, 50}, 600, 700);

            // Build graphic in image, drawing axis, unities lines and ranges
            g.drawAxis(600, 300, new double[] {thetaRange, thetaRange*(-1)}, new double[] {-100, 10}, img);
            g.drawUnitsAxis(40, img);
            g.drawRangesOnAxis(img);

            // Estimation for a individual student
            Estimator estimator = new Estimator(examBoard.getExam().getQuestionsMap(), iterator.next());
            double bestTheta = thetaRange;
            double maxFuncValue = estimator.lnLikelihood(thetaRange);

            // Take theta where the function is maximum
            for (double i = thetaRange; i < thetaRange * (-1); i += precision)
            {
                double functionValue = estimator.lnLikelihood(i);
                g.drawPoint(i, functionValue, 2,img);

                if(functionValue >= maxFuncValue)
                {
                    maxFuncValue = functionValue;
                    bestTheta = i;
                }
            }

            System.out.println("Theta estimated for the student " + student + ": " + bestTheta);

            // Sets student's ability
            estimator.getStudent().ability = bestTheta;

            // Take the minimum and maximum theta among all students
            if(bestTheta > thetaMax) thetaMax = bestTheta;
            if(bestTheta < thetaMin) thetaMin = bestTheta;

            // Write subtitles on left top
            img.drawString("Ln-Likelihood Function", 10, 20);
            img.drawString("Student" + student + ": Theta estimated " + bestTheta, 10, 40);

            // Save image in system
            img.save("src\\Results\\Student" + student + ".png");

            student++;
        }


        System.out.println("\nThe maximum theta among " + examBoard.getNumberOfExams() + " students was: " + thetaMax);
        System.out.println("The minimum theta among " + examBoard.getNumberOfExams() + " students was: " + thetaMin);
    }
}
