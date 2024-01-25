package Pattern.MVC.view.ui.textPannel;

import Pattern.MVC.view.ui.TextualUIElement;

import java.util.ArrayList;
import java.util.List;

public class TextPanel implements TextualUIElement {
    private String titel;
    private List<TextualUIElement> elements = new ArrayList<TextualUIElement>();

    public TextPanel(String titel) {
        this.titel = titel;
    }

    public void add(TextualUIElement element) {
        elements.add(element);
    }
    @Override
    public String draw() {
        String output = "";
        for (TextualUIElement element : elements) {
            output = output.concat(element.draw());
        }
        return "Pannel " + titel  +" "+ output;
    }
}
