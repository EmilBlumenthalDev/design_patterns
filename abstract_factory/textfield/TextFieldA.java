package abstract_factory.textfield;

public class TextFieldA extends TextField {
    private String text;

    public void display() {
        System.out.println("[TextFieldA: - " + text + " - : __________ ]");
    }

    public void setText(String text) {
        this.text = text;
    }
}