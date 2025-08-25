package abstract_factory.checkbox;

public class CheckboxA extends Checkbox {
    private String text;

    public void display() {
        System.out.println("CheckboxA - " + text + " - [ ]");
    }

    public void setText(String text) {
        this.text = text;
    }
}
