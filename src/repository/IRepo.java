package repository;

import exceptions.RepoException;
import model.state.PrgState;

public interface IRepo {
    public PrgState getCrtPrg();
    public void add(PrgState state);
    void logPrgStateExec() throws RepoException;
}
