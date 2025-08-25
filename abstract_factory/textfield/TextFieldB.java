package abstract_factory.textfield;

public class TextFieldB extends TextField {
    private String text;

    public void display() {
        System.out.println("[TextFieldB - " + text + " - : __________ ]");
    }

    public void setText(String text) {
        this.text = text;
    }
}