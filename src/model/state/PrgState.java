package model.state;

import model.ADT.*;
import model.values.*;
import model.statements.*;

public class PrgState {
    public MyIStack<IStatement> getExeStack() {
        return exeStack;
    }

    public MyIMap<String, IValue> getSymTbl() {
        return symTbl;
    }

    public MyIList<IValue> getOutList() {
        return outList;
    }

    private MyIStack<IStatement> exeStack;
    private MyIMap<String,IValue> symTbl;
    private MyIList<IValue> outList;
    public PrgState() {
        this.exeStack = new MyStack<IStatement>();
        this.symTbl = new MyMap<String,IValue>();
        this.outList = new MyList<IValue>();
    }

    public String toString(){
        return "PrgState : \n"+exeStack.toString()+"\n"+symTbl.toString()+"\n"+outList.toString();

    }
}
