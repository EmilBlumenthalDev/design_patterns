package abstract_factory.checkbox;

public class CheckboxB extends Checkbox {
    private String text;

    public void display() {
        System.out.println("CheckboxB - " + text + " - [ ]");
    }

    public void setText(String text) {
        this.text = text;
    }
}
