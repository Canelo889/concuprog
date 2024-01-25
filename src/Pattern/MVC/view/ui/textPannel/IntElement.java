package Pattern.MVC.view.ui.textPannel;

import Pattern.MVC.view.ui.TextualUIElement;

public class IntElement implements TextualUIElement {
    private Integer value;

    public IntElement(Integer value) {
        this.value = value;
    }

    public void update(Integer value) {
        this.value = value;
    }

    public Integer getValue(){
        return value;
    }
    @Override
    public String draw() {
        return value.toString();
    }
}
