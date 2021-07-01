import java.util.Scanner;

public class Menu {

    public static String showMenu(){
        Scanner sc = new Scanner(System.in);
        String choice = null;
        System.out.println("""
                1) "add" - Add new Reminder
                2) "show" - Show all Reminders
                3) "quit" - Quit
                """);

        System.out.print("Your choice: ");
        choice = sc.next();
        return choice;
    }
}
