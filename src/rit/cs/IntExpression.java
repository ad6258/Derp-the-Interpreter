package rit.cs;

/**
 * This class encapsulates a field and methods to be performed on a tree node with integer value
 * IntExpression implements the interface Expression
 *
 * @author Atharva Dhupkar ad6258@g.rit.edu
 */
public class IntExpression implements Expression {
    /**
     * value is of type int and it stores the integer
     */
    private int value;

    /**
     * This constructor initializes value(field) as value(parameter)
     * @param value integer
     */
    public IntExpression(int value){
        this.value = value;
    }

    /**
     * This method evaluates the instance by returning an int value
     * @return int value
     */
    @Override
    public int evaluate(){
        return this.value;
    }

    /**
     * This method emits by return the instance in the form of a string
     * @return
     */
    @Override
    public String emit(){
        return "" + this.value; // concatenate value to empty string
    }
}
