package rit.stu;

import rit.cs.*;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * This class encapsulated the functions of Derp Your Interpreter.
 * Derp accepts prefix mathematical expressions (the mathematical operation is written at
 * the beginning rather than in the middle).
 * Derp then converts it to a tree using the parse function
 * +, -, *, x, /, * are allowed for operations and only integer literals for operands
 * Derp then evaluates the tree and then emits(prints) it.
 *
 * @author Atharva Dhupkar ad6258@g.rit.edu
 */
public class DYI {
    /**
     * Scanner "in" for input
     */
    private Scanner in;
    /**
     * root of the tree i.e. first node
     */
    private Expression root;
    /**
     * tokens is a list of the prefix expression that is entered by the user.
     * each index has a single operator or operand.
     */
    private ArrayList<String> tokens;
    public DYI(Scanner in){
        this.in = in;
    }

    /**
     * this method asks the user for input of the prefix expression and uses a for loop
     * to convert it to an ArrayList of type String.
     * @param in Scanner
     * @return boolean: true if a prefix expression is input, false if quit is input
     */
    private boolean makeTokensList(Scanner in){
        System.out.print(">");
        String prefix = in.nextLine(); // input
        if(prefix.equals("quit")){ //quitting
            return false;
        }
        int i = 0;
        tokens = new ArrayList<String>(prefix.length());
        String temp = "";
        char character = prefix.charAt(i);

        while(true){
            // for double digit numbers
            while(character != ' ') {
                // to store character in temp until next character is a space
                if (temp.equals("")) {
                    temp = "" + character;
                }
                // if temp already has a character in it
                else {
                    temp = temp + character;
                }
                i++;
                // to make sure i does not exceed length
                if(i < prefix.length()) {
                    character = prefix.charAt(i);
                }
                else
                    break;
            }
            tokens.add("" + temp);
            temp = "";
            i++;
            // to make sure i does not exceed length
            if(i < prefix.length()) {
                character = prefix.charAt(i);
            }
            else
                break;

        }
        return true;
    }

    /**
     * This function makes a tree out of the tokens list
     * Depending on the type of operator it returns a new instance of its
     * respective class.
     * Eg. is the operator is + it would return a new
     * instance of AddExpression.
     * this is a recursive function so it calls the parse function again
     * as parameters of the constructor
     * Eg. return new AddExpression(parse(tokens), parse(tokens)
     * BASE CASE: if the node is an integer it returns an instance
     * of the IntExpression class without any recursive case
     * @param tokens list of tokens
     * @return new instance of Expression
     */
    private Expression parse(ArrayList<String> tokens) {
        String firstToken = tokens.remove(0);
        if(firstToken.equals("+")){
            return new AddExpression(parse(tokens), parse(tokens));
        }
        else if(firstToken.equals("-")){
            return new SubExpression(parse(tokens), parse(tokens));
        }
        else if(firstToken.equals("/")){
            return new DivExpression(parse(tokens), parse(tokens));
        }
        else if(firstToken.equals("*") || firstToken.equals("x")){
            return new MulExpression(parse(tokens), parse(tokens));
        }
        else if(firstToken.equals("%")){
            return new DivExpression(parse(tokens), parse(tokens));
        }
        else{
            return new IntExpression(Integer.parseInt(firstToken));
        }
    }

    /**
     * this is the doLoop method of DYI that gets everything started.
     * It loops over makeTokenList which returns a boolean (true if a prefix expression
     * is input, false if quit is input) depending on if the user wants to quit or not.
     * if not quit, it emits and evaluates the expression.
     */
    public void doLoop(){
        boolean choice;
        System.out.println("Derp Your Interpreter v1.0");
        choice = makeTokensList(in);
        while(choice) {
            root = parse(tokens);
            System.out.println("Emit: " + root.emit());
            System.out.println("Evaluate: " + root.evaluate());
            choice = makeTokensList(in);
        }
        System.out.println("Goodbye :'(");
    }

    /**
     * main function initializes a Scanner "in" and makes a new object "helper" of class DYI.
     * it calls the doEverything function ot pass the control to the object "helper"
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DYI helper = new DYI(in);
        helper.doLoop();
        in.close();
    }
}
