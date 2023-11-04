/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Calculate {

    List<Float> superlativeEquation(float A, float B, List<Float> number) {
        //Check number is empty
        //if (number.isEmpty()) {
            number.add(A);
            number.add(B);
        //}
        List<Float> solution = null;
        //Check equation have no solution 
        if (A == 0 && B != 0) {
            return solution;
        }
        solution = new ArrayList<>();
        //Check equation have infinity many solution
        if (A == 0 && B == 0) {
            return solution;
        } else {
            float x = -B / A;
            number.add(x);
            solution.add(x);
        }
        return solution;
    }

    List<Float> quadraticEquation(float A, float B, float C, List<Float> number) {
        number.add(A);
        number.add(B);
        number.add(C);
        List<Float> solution = null;
        float delta = B * B - 4 * A * C;
        //Check the case of the equation when a is not 0
        if (A != 0) {
            //If delta < 0 then return no solution
            if (delta < 0) {
                return solution;
            }
            solution = new ArrayList<>();
            //If delta greater or equal than zero then return two solutions
            if (delta >= 0) {
                float x1, x2;
                x1 = (-B + (float) Math.sqrt(delta)) / (2 * A);
                x2 = (-B - (float) Math.sqrt(delta)) / (2 * A);
                number.add(x1);
                number.add(x2);
                solution.add(x1);
                solution.add(x2);
            }
        } else {
            solution = superlativeEquation(B, C, number);
        }
        return solution;
    }
}
