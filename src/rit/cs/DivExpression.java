package rit.cs;

public class DivExpression implements Expression {
    private Expression left, right;
    public DivExpression(Expression left, Expression right){
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
