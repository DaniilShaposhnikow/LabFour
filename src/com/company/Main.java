package com.company;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        double X = in.nextDouble();
        if(X <= 0)
        {
            double p = (((Cot(X) - Csc(X))) * Tan(X)) * Csc(X) - Sin(X) / (Cos(X) + Cos(X));
            System.out.println(p);
        }
        else if(X > 0)
        {
            double s = Stepen((Log(X, 10) * Log(X, 3.0)) - Log(X, 5.0) * (Log(Stepen(X, 3.0), 2)), 2.0) - (Ln(X) * (Log(Stepen(X, 2.0), 5.0)) + Log(Stepen(X, 3.0), 10));
            System.out.println(s);
        }
    }

    public static double Stepen(double A, double B)
    {
        double A1 = 1;
        for(int i = 1; i<=B; i++)
        {
            A1 *= A;
        }
        return A1;
    }

    public static double Fact(double A)
    {
        double A1 = 1;
        for(int i = 1; i<=A; i++)
        {
            A1 *= i;
        }
        return A1;
    }

    public static double Sin(double X)
    {
        double A1 = 1000;
        double x1 = 0;
        for(int n = 0; n<A1; n++ )
        {
            x1 += Stepen(-1, n) * Stepen(X, 2 * n +1) / Fact(2 * n + 1);
        }
        return x1;
    }

    public static double Cos(double X)
    {
        double Tochnost = 1000;
        double Save = 0;
        for(int n = 0; n<Tochnost; n++)
        {
            Save += Stepen(-1, n) * Stepen(X, 2*n) / Fact(2 * n);
        }
        return Save;
    }

    public static double Cot (double X)
    {
        return Cos(X) / Sin(X);
    }

    public static double Csc (double X)
    {
        return 1 / Sin(X);
    }

    public static double Tan (double X)
    {
        return Sin(X) / Cos(X);
    }

    public static double Ln (double X)
    {
        double tochnost = 1000;
        double save = 0;
        double y = 1 + X;
        for(int n = 1; n < tochnost; n++ )
        {
            save += Stepen(-1, n + 1) + Stepen(X-1, n) / Fact(n);
        }
        return save;
    }

    public static double Log(double A, double B)
    {
        return Ln(B) / Ln(A);
    }

}

