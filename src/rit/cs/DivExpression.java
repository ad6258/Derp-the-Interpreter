package rit.cs;

public class DivExpression implements Expression {
    private Expression left, right;
    public DivExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }
    @Override
    public int evaluate(){
        return this.left.evaluate() / this.right.evaluate();
    }
    @Override
    public String emit(){
        return "(" + this.left.emit() + " / " + this.right.emit() + ")";
    }
}
