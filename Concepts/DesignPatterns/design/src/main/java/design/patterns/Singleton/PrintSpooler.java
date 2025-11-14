package design.patterns.Singleton;

// using static variable but its not thread safe
public class PrintSpooler {

    private PrintSpooler(){};

    private static PrintSpooler INSTANCE;

    // Method can be made synchronized to make it thread safe
    public static PrintSpooler getPrintSpooler(){
        if(INSTANCE == null) INSTANCE = new PrintSpooler();
        return INSTANCE;
    }

    public void print(String s){
        System.out.println(s);
    }
}
