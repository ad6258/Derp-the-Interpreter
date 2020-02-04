package rit.cs;

/**
 * This is an interface for a general expression
 */
public interface Expression {
    /**
     * this is a method for evaluating an Expression
     * @return integer after the Expression has been evaluated
     */
    public int evaluate();

    /**
     * This method is for emitting an Expression in the form of a string
     * @return String expression
     */
    public String emit();

}
