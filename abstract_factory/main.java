package abstract_factory;

import abstract_factory.uifactory.AFactory;
import abstract_factory.uifactory.UIFactory;

public class main {
    public static void main(String[] args) {
        UIFactory factory = new AFactory();

        Input button = factory.createButton("Click Me");
        Input textField = factory.createTextField("Enter Text");
        Input checkbox = factory.createCheckbox("Accept Terms");

        button.display();
        textField.display();
        checkbox.display();

        button.setText("New Button Text");
        textField.setText("New TextField Text");
        checkbox.setText("New Checkbox Text");

        button.display();
        textField.display();
        checkbox.display();
    }
}
