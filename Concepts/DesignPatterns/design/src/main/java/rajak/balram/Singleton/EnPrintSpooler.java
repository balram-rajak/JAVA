package main.java.rajak.balram.Singleton;

public enum EnPrintSpooler {

    INSTANCE;

    private EnPrintSpooler(){}

    public EnPrintSpooler getInstance(){
        return INSTANCE;
    }
}
