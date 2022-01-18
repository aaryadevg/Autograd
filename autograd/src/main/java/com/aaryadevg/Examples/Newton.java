package com.aaryadevg.Examples;
import java.util.Scanner;

import com.aaryadevg.*;

public class Newton {
    public static Variable F(Variable x) {
        // f(x) = x^3 + 3x
        // f'(x) = 3x^2 + 3
        Variable res = Operations.add( Operations.pow(x, new Variable(3)), Operations.multiply(x, new Variable(3)) );
        return res;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter starting value: ");
        Variable x = new Variable(input.nextDouble(), true);
        int i = 1;

        while (true) {
            Variable f = F(x);  
            f.backward(1.0);

            double fPrime = x.getGrad();
            double newValue = x.getValue() - (f.getValue() / fPrime);
            
            System.out.printf("Iteration %2d: x = %.4f, f(x) = %.4f, f'(x) = %.4f\n", i, x.getValue(), f.getValue(), fPrime);
            x = new Variable(newValue, true);
            i++;
            
            if (f.getValue() < 0.000001) {
                break;
            }
        }
        input.close();
    }
}
