package com;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by hootting on 2016. 5. 20..
 * when a user input formula, it calculates automatically
 */
public class inputCalculator {

    /**
     * Parameters
     * List below must be sorted
     * LN : list of numbers that you want to operate
     * LO : list of operations
     * operation : operations
     */

    /*
        This Function is to make a list of numbers, operations when a user input formula.

        For example when user input 10 + 4 * 5 + 8 /4
        Then this function will make a list of number which includes 10,4,5,8,4
        and make a list of operations which includes +,*,+,/
     */
    private static void InputTokenizer(List<Double> LN, PriorityQueue<Operation> LO, String input) {

        /*
        To prevent NullPointerException
         */
        if (LN == null)
            LN = new ArrayList<Double>();
        else if (LO == null)
            LO = new PriorityQueue<Operation>();

        String token; // A temp variable which saves token.
        StringTokenizer st = new StringTokenizer(input); // StringTokenizer Initialize

        // Save numbers into list
        while (st.hasMoreTokens()) { // To save all numbers
            if ((token = st.nextToken("[+-*/]")) != null) {
                LN.add(Double.valueOf(token));
            }
        }
        // End

        // Save operations into list
        input = input.replaceAll("\\d", " "); // In order to tokenize operation, make all numbers into blank(space)
        st = new StringTokenizer(input);
        while (st.hasMoreTokens()) {
            LO.add(new Operation(st.nextToken().charAt(0)));
        }
        // End
    }


    /*
        This Function is to calculate a list of numbers by a list of operation in certain sequence.

        Parameter
            operation : Operations that you want to operate.
            For example, if you want to operate +,- first, then your operation will be "+-"
                         or if you want to operate *,+ first, then your operation will be "*+"

        In general, * / operation will be operated first, + - operation will be operated second.
     */

    private static void Calculator(List<Double> LN, PriorityQueue<Operation> LO) {
        Operation temp; // A temp variable that save a operation
        Double result = null; // A temp variable that save a operated result

        while (!LO.isEmpty()) {
            temp = LO.poll(); // Pick top element from PriorityQueue and delete it

            for(Operation t : LO) // Reorganize order
                if(t.getOrder()>temp.getOrder())
                    t.setOrder(t.getOrder()-1);

            //Operate

            if (temp.getOperation() == '*')
                result = LN.get(temp.getOrder()) * LN.get((temp.getOrder()) + 1);
            if (temp.getOperation() == '/')
                result = LN.get((temp.getOrder())) / LN.get((temp.getOrder() + 1));
            if (temp.getOperation() == '+')
                result = LN.get((temp.getOrder())) + LN.get((temp.getOrder() + 1));
            if (temp.getOperation() == '-')
                result = LN.get(temp.getOrder()) - LN.get(temp.getOrder() + 1);

            LN.remove((int)temp.getOrder());
            LN.remove((int)temp.getOrder());
            LN.add(temp.getOrder(), result);
        }
    }


    public static void main(String[] args) {
        List<Double> number = new ArrayList<Double>(); // A list that saves numbers
        PriorityQueue<Operation> operation = new PriorityQueue<Operation>(); // A PriorityQueue that saves operations by certain order
        Scanner sc = new Scanner(System.in); // Scanner instance initialize
        String input = sc.nextLine(); // Input from user

        InputTokenizer(number, operation, input); // Input to lists

        Calculator(number, operation); // Calculate

        System.out.println(number.get(0)); // When operation ends the result will be saved in 0th.


    }

}