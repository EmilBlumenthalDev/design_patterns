package abstract_factory.uifactory;

public abstract class UIFactory {
    public abstract abstract_factory.button.Button createButton(String text);
    public abstract abstract_factory.textfield.TextField createTextField(String text);
    public abstract abstract_factory.checkbox.Checkbox createCheckbox(String text);
}