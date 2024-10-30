package repository;

import exceptions.RepoException;
import model.state.PrgState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Repo implements IRepo {
    private List<PrgState> stateList;
    private int currentPrgStatePos;
    private String logFilePath;

    public Repo(String logFilePath) {
        this.logFilePath = logFilePath;
        this.stateList = new ArrayList();
        this.currentPrgStatePos = 0;
    }

    //TODO: de verificat daca e - si dam exceptie ca poate crapa
    public PrgState getCrtPrg() {
        return stateList.get(currentPrgStatePos);
    }

    public void add(PrgState state) {
        stateList.add(state);
    }

   public void logPrgStateExec() throws RepoException {
        try {
            PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
            logFile.println(this.getCrtPrg());
            logFile.close();
        } catch (IOException e) {
            throw new RepoException(e.getMessage());
        }
    }
}
