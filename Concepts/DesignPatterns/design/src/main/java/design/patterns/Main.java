package design.patterns;

import design.patterns.Singleton.PdfPrinter;

public class Main {
    public static void main(String[] args) {
        new PdfPrinter().print(" PdfPrinter working");
    }
}