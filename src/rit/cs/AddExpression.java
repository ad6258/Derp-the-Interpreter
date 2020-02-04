package rit.cs;

/**
 * This class encapsulates fields and methods to perform addition on a tree
 * AddExpression implements the interface Expression
 *
 * @author Atharva Dhupkar ad6258@g.rit.edu
 */
public class AddExpression implements Expression {
    /**
     * left and right of type Expression are variables for the left and right nodes of "+" node
     */
    private Expression left, right;

    /**
     * AddExpression instantiates left(field) and right(field) with the parameters left and right respectively.
     * @param left left node of type Expression of "+"
     * @param right right node of type Expression of "+"
     */
    public AddExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    /**
     * This method adds the left and right nodes after they've been evaluated
     * @return sum of type int
     */
    @Override
    public int evaluate(){
        return this.left.evaluate() + this.right.evaluate();
    }

    /**
     * emit prints the expression that is to be added
     * @return String of the expression to be printed
     */
    @Override
    public String emit(){
        return "(" + this.left.emit() + " + " + this.right.emit() + ")";
    }
}
