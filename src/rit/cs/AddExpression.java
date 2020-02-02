package rit.cs;

public class AddExpression implements Expression {
    private Expression left, right;
    public AddExpression(Expression left, Expression right){
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
