package abstract_factory.uifactory;

import abstract_factory.button.ButtonB;
import abstract_factory.textfield.TextFieldB;
import abstract_factory.checkbox.CheckboxB;

public class BFactory extends UIFactory {
    public ButtonB createButton(String text) {
        ButtonB button = new ButtonB();
        button.setText(text);
        return button;
    }

    public TextFieldB createTextField(String text) {
        TextFieldB textField = new TextFieldB();
        textField.setText(text);
        return textField;
    }

    public CheckboxB createCheckbox(String text) {
        CheckboxB checkbox = new CheckboxB();
        checkbox.setText(text);
        return checkbox;
    }
}
