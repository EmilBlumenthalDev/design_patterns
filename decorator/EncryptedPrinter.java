package decorator;

public class EncryptedPrinter implements Printer {
    private Printer printer;

    public EncryptedPrinter(Printer printer) {
        this.printer = printer;
    }

    private String encrypt(String message) {
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            sb.append((char) (c + 3));
        }
        return sb.toString();
    }

    @Override
    public void print(String message) {
        String encryptedMessage = encrypt(message);
        printer.print(encryptedMessage);
    }
}
