package design.patterns.Singleton;

public enum EnPrintSpooler {

    INSTANCE;

    private EnPrintSpooler(){}

    public EnPrintSpooler getInstance(){
        return INSTANCE;
    }
}
