package model.statements;

import exceptions.ADTException;
import exceptions.StatementException;
import model.state.PrgState;

public interface IStatement {
    public PrgState execute(PrgState p) throws StatementException, ADTException;
}
