package Pattern.MVC.view.ui.textPannel;

import Pattern.MVC.view.ui.TextualUIElement;

public class TextElement implements TextualUIElement {
    private String text;

    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public String draw() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
