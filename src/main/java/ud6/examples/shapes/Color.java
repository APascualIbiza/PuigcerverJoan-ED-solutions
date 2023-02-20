package ud6.examples.shapes;

public enum Color {
    BLACK ("\u001b[30m"),
    RED("\u001b[31m"),
    GREEN("\u001b[32m"),
    YELLOW("\u001b[33m"),
    BLUE("\u001b[34m"),
    MAGENTA("\u001b[35m"),
    CYAN("\u001b[36m"),
    WHITE("\u001b[37m"),
    RESET("\u001b[0m");

    private String code;

    Color(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

    public static void main(String[] args) {
        System.out.println(RED + "Aquest text és roig" + RESET);
        System.out.println(GREEN + "Aquest text és verd" + RESET);
    }
}
