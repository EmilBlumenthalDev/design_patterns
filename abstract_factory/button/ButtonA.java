package abstract_factory.button;

public class ButtonA extends Button {
    private String text;

    public void display() {
        System.out.println("[ ButtonA: " + text + " ]");
    }

    public void setText(String text) {
        this.text = text;
    }
}
