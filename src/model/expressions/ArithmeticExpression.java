package model.expressions;


import model.ADT.MyIMap;
import model.types.IntType;
import model.values.IValue;
import exceptions.ExpressionException;
import model.values.IntValue;

public class ArithmeticExpression implements IExpression {
    private IExpression left;
    private IExpression right;
    private ArithmeticalOperator operator;
    public ArithmeticExpression(IExpression left, ArithmeticalOperator operator, IExpression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }
    public IValue eval(MyIMap symTbl) throws ExpressionException {
        IValue leftValue = left.eval(symTbl);
        IValue rightValue = right.eval(symTbl);
        if (!leftValue.getType().equals(new IntType())) {
            throw new ExpressionException(" Value " + leftValue + " is not an Int type");
        }
        if (!rightValue.getType().equals(new IntType())) {
            throw new ExpressionException(" Value " + rightValue + " is not an Int type");
        }
        IntValue leftInt = (IntValue)leftValue;
        IntValue rightInt = (IntValue)rightValue;
        switch (operator){
            case PLUS:
                return new IntValue(leftInt.getValue() + rightInt.getValue());
            case MINUS:
                return new IntValue(leftInt.getValue() - rightInt.getValue());
            case MULTIPLY:
                return new IntValue(leftInt.getValue() * rightInt.getValue());
                case DIVIDE:
                    if (rightInt.getValue() == 0) {
                        throw new ExpressionException("Division by zero");
                    }
                    return new IntValue(leftInt.getValue() / rightInt.getValue());

            default:
                throw new ExpressionException("Unknown operator " + operator);
        }
    }

}
