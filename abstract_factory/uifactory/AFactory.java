package abstract_factory.uifactory;

import abstract_factory.button.ButtonA;
import abstract_factory.textfield.TextFieldA;
import abstract_factory.checkbox.CheckboxA;

public class AFactory extends UIFactory {
    public ButtonA createButton(String text) {
        ButtonA button = new ButtonA();
        button.setText(text);
        return button;
    }

    public TextFieldA createTextField(String text) {
        TextFieldA textField = new TextFieldA();
        textField.setText(text);
        return textField;
    }

    public CheckboxA createCheckbox(String text) {
        CheckboxA checkbox = new CheckboxA();
        checkbox.setText(text);
        return checkbox;
    }
}
