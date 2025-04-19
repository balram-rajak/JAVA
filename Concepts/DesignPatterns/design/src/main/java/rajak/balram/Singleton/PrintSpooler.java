package main.java.rajak.balram.Singleton;

public class PrintSpooler {

    private PrintSpooler(){};

    private static PrintSpooler INSTANCE;

    public static PrintSpooler getPrintSpooler(){
        if(INSTANCE == null) INSTANCE = new PrintSpooler();
        return INSTANCE;
    }

    public void print(String s){
        System.out.println(s);
    }
}
