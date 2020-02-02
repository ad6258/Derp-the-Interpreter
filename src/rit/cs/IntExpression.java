package rit.cs;

public class IntExpression implements Expression {
    private int value;
    public IntExpression(int value){
    }
    @Override
    public int evaluate(){
        return 0;
    }
    @Override
    public String emit(){
        return null;
    }
}
