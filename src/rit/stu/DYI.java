package rit.stu;

import rit.cs.*;

import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 */
public class DYI {
    private Scanner in = new Scanner(System.in);
    private Expression root;
    private ArrayList<String> tokens;
    public DYI(Scanner in){
        this.in = in;
    }
    private void makeToken(Scanner in){
        System.out.print(">");
        String prefix = in.nextLine();
        tokens = new ArrayList<String>(prefix.length());
        for (int i = 0; i < prefix.length(); i++ ){
            if(prefix.charAt(i) != ' '){
                tokens.add("" + prefix.charAt(i));
            }
        }
        root = parse(tokens);
    }

    private Expression parse(ArrayList<String> tokens) {
        String thing = tokens.remove(0);
        if(thing.equals("+")){
            return new AddExpression(parse(tokens), parse(tokens));
        }
        else if(thing.equals("-")){
            return new SubExpression(parse(tokens), parse(tokens));
        }
        else if(thing.equals("/")){
            return new DivExpression(parse(tokens), parse(tokens));
        }
        else if(thing.equals("*") || thing.equals("x")){
            return new AddExpression(parse(tokens), parse(tokens));
        }
        else if(thing.equals("%")){
            return new DivExpression(parse(tokens), parse(tokens));
        }
        else{
            return new IntExpression(Integer.parseInt(thing));
        }
    }

    public void doEverything(){
        System.out.println("Derp Your Interpreter v1.0");
        makeToken(in);
        System.out.println("Emit: " + root.emit());
        System.out.println("Evaluate: " + root.evaluate());
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DYI helper = new DYI(in);
        helper.doEverything();
        in.close();
    }
}
