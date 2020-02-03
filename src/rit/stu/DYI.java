package rit.stu;

import rit.cs.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DYI {
    private Scanner in = new Scanner(System.in);
    private Expression root;
    private ArrayList<String> token, tokenLeft, tokenRight;
    public DYI(Scanner in){
        this.in = in;
    }
    private void makeToken(Scanner in){
        System.out.print(">");
        String prefix = in.nextLine();
        token = new ArrayList<String>(prefix.length());
        for (int i = 0; i < prefix.length(); i++ ){
            if(prefix.charAt(i) != ' '){
                token.add("" + prefix.charAt(i));
            }
        }
        root = parse(token);
    }

    private Expression parse(ArrayList<String> token) {
        if(token.get(0).equals("+")){
            String thingLeft = token.remove(0);
            tokenLeft = token;
            String thingRight = token.remove(0);
            tokenRight = token;
            return new AddExpression(parse(tokenLeft), parse(tokenRight));
        }
        else if(token.get(0).equals("-")){
            String thingLeft = token.remove(0);
            tokenLeft = token;
            String thingRight = token.remove(0);
            tokenRight = token;
            return new SubExpression(parse(tokenLeft), parse(tokenRight));
        }
        else if(token.get(0).equals("/")){
            String thingLeft = token.remove(0);
            tokenLeft = token;
            String thingRight = token.remove(0);
            tokenRight = token;
            return new DivExpression(parse(tokenLeft), parse(tokenRight));
        }
        else if(token.get(0).equals("*") || token.get(0).equals("x")){
            String thingLeft = token.remove(0);
            tokenLeft = token;
            String thingRight = token.remove(0);
            tokenRight = token;
            return new AddExpression(parse(tokenLeft), parse(tokenRight));
        }
        else if(token.get(0).equals("%")){
            String thingLeft = token.remove(0);
            tokenLeft = token;
            String thingRight = token.remove(0);
            tokenRight = token;
            return new DivExpression(parse(tokenLeft), parse(tokenRight));
        }
        else{
            return new IntExpression(Integer.parseInt(token.remove(0)));
        }
    }

    public void doEverything(){
        System.out.println("Derp Your Interpreter v1.0");
        makeToken(in);
        System.out.println(root.emit());
        System.out.println(root.evaluate());
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DYI helper = new DYI(in);
        helper.doEverything();
        in.close();
    }
}
