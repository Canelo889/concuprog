package Pattern.MVC.view.ui.menu;

public enum Colors {
    RED("\033[0;31m"),
    BLACK("\033[0m");

    private final String value;

    private Colors(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
