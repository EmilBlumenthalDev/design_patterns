package decorator;

public class XMLPrinter implements Printer {
    private Printer printer;

    public XMLPrinter(Printer printer) {
        this.printer = printer;
    }

    public void print(String message) {
        String xmlMessage = "<message>" + message + "</message>";
        printer.print(xmlMessage);
    }
}
