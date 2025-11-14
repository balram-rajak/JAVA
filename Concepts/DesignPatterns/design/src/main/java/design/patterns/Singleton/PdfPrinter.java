package design.patterns.Singleton;
public class PdfPrinter {

    private PrintSpooler p;

    public PdfPrinter(){
        this.p = PrintSpooler.getPrintSpooler();
    }

    public void print(String s){
        p.print(s);
    }
}
