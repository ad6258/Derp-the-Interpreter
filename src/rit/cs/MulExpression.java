package rit.cs;

public class MulExpression implements Expression {
    private Expression left, right;
    public MulExpression(Expression left, Expression right){
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
