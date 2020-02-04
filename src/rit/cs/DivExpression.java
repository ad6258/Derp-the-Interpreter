package rit.cs;
/**
 * This class encapsulates fields and methods to perform division on a tree
 * DivExpression implements the interface Expression
 *
 * @author Atharva Dhupkar ad6258@g.rit.edu
 */
public class DivExpression implements Expression {
    /**
     * left and right of type Expression are variables for the left and right nodes of "/" node
     */
    private Expression left, right;

    /**
     * DivExpression instantiates left(field) and right(field) with the parameters left and right respectively.
     * @param left left node of type Expression of "/" node
     * @param right right node of type Expression of "/" node
     */
    public DivExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    /**
     * This method divides the left and right nodes after they've been further evaluated
     * @return quotient of type int
     */
    @Override
    public int evaluate(){
        return this.left.evaluate() / this.right.evaluate();
    }

    /**
     * emit returns the expression that is to be divided in string form
     * @return String of the expression to be printed
     */
    @Override
    public String emit(){
        return "(" + this.left.emit() + " / " + this.right.emit() + ")";
    }
}
