package core;

public interface Controller {

    void start();
    boolean dispatchCommand(int command) throws Exception;
}
