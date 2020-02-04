package rit.cs;

/**
 * This class encapsulates fields and methods to perform mod function on a tree's nodes
 * ModExpression implements the interface Expression
 *
 * @author Atharva Dhupkar ad6258@g.rit.edu
 */
public class ModExpression implements Expression {
    /**
     * left and right of type Expression are variables for the left and right nodes of "%" node
     */
    private Expression left, right;

    /**
     * ModExpression instantiates left(field) and right(field) with the parameters left and right respectively.
     * @param left left node of type Expression of "%" node
     * @param right right node of type Expression of "%" node
     */
    public ModExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    /**
     * This method adds the left and right nodes after they've been further evaluated
     * @return modulus of type int
     */
    @Override
    public int evaluate(){
        return this.left.evaluate() % this.right.evaluate();
    }

    /**
     * emit returns the expression that is in string form with % sign
     * @return String of the expression to be printed
     */
    @Override
    public String emit(){
        return "(" + this.left.emit() + " % " + this.right.emit() + ")";
    }
}
