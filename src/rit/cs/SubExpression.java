package rit.cs;

public class SubExpression implements Expression {
    private Expression left, right;
    public SubExpression(Expression left, Expression right){
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
