package rit.cs;

public class ModExpression implements Expression {
    private Expression left, right;
    public ModExpression(Expression left, Expression right){
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
