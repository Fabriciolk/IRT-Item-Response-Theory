package Statistic.Functions;

public abstract class TRIFunction implements Function
{
    /*
    *
    *   This class refers to all function that is used to estimate a student's ability
    *
     */

    double a;
    double b;
    double c;

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

    public boolean equals(Object obj)
    {
        if(obj instanceof TRIFunction)
        {
            return a == ((TRIFunction) obj).getA() && b == ((TRIFunction) obj).getB() && c == ((TRIFunction) obj).getC();
        }
        return false;
    }

    public int hashCode()
    {
        return (int)(getA()*100 + getB()*10 + getC());
    }

    @Override
    public String toString() {
        return "TRIFunction{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
