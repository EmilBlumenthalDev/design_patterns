package abstract_factory.button;

public class ButtonB extends Button {
    private String text;

    public void display() {
        System.out.println("[ ButtonB: " + text + " ]");
    }

    public void setText(String text) {
        this.text = text;
    }
}