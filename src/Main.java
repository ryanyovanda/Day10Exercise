package Library;
import Library.MainMenu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Library Management System");
        MainMenu menu = new MainMenu();
        menu.run();
    }
}