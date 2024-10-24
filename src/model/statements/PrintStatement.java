package model.statements;

import exceptions.StatementException;
import model.expressions.IExpression;
import model.state.PrgState;
import model.values.IValue;

public class PrintStatement implements IStatement{
   private IExpression expression;
   public PrintStatement(IExpression expression){
       this.expression = expression;
   };
    public PrgState execute(PrgState p){
        IValue v = expression.eval(p.getSymTbl());
        p.getOutList().add(v);
        return p;
    };
    public String toString(){
        return "print("+expression+")";
    };
}
