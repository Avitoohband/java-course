package dictionary;
import java.util.*;

public class DictApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Dictionary dict = new Dictionary();
        Menu.showMenu();
        int option = scan.nextInt();

        while(true){

            switch (option){
                case 1:{
                    dict.printAllEntrySorted();
                    break;
                }
                case 2:{
                    System.out.println("Insert a Key add");
                    String key = scan.next();
                    System.out.println("Insert a Value");
                    String val = scan.nextLine();
                     val = scan.nextLine();
                    dict.addToDictionary(key, val);
                    break;
                }
                case 3:{
                    dict.printKeys();
                    System.out.println("Insert a Key to edit");
                    String key = scan.next();
                    System.out.println("Insert a Value");
                    String val = scan.nextLine();
                     val = scan.nextLine();
                    dict.edit(key, val);
                    break;
                }
                case 4:{
                    dict.printKeys();
                    System.out.println("Insert a Key to remove");
                    String key = scan.next();
                    dict.removeKey(key);
                    break;
                }
                case 5:{
                    Menu.showMenu();
                    break;
                }
                default:{
                    System.exit(0);
                }
            }
            option = scan.nextInt();
        }

    }
}
