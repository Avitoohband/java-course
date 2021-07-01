
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Set;

public class Program {

    public static final int VALID_DAY = 1;

    private static void showReminders(RemindersHolder rh){
        rh.showReminders();
    }
    private static int checkValidDay(int year, int month, int day){

        boolean isLeap = year % 4 == 0 && year % 100 != 0;
        int maxDays = 31 ;
        if(month == 2){
            maxDays = isLeap ? 28 : 29;
        }
        else if (month == 4 || month == 6 ||month == 9 ||month == 11 ){
            maxDays = 30;
        }
        if(day > maxDays){
            return maxDays;
        }
        return VALID_DAY;
    }
    private static void addReminder(RemindersHolder rh)throws  DateCreationException{

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a date");

        System.out.print("Year: ");
        int year = Integer.parseInt(scan.nextLine());
        if(year > 2300 || year < 1920){
            throw new DateCreationException("the year " + year + " is not in range(1920 - 2300)");
        }
        System.out.print("Month: ");
        int month = Integer.parseInt(scan.nextLine());
        if(month < 1 || month > 12){
            throw new DateCreationException("the month " + month + " is not in range(1 -  12)");
        }
        System.out.print("Day: ");
        int day = Integer.parseInt(scan.nextLine());
        int tempValidDay = checkValidDay(year, month, day);
        if(tempValidDay != VALID_DAY){
            throw new DateCreationException("the day " + day + " is not in range(1 - " + tempValidDay +")");
        }
        System.out.print("Hour : ");
        int hour = Integer.parseInt(scan.nextLine());
        if(hour > 23 || hour < 0){
            throw new DateCreationException("the hour " + hour + " is not in range(1 - 12 , 13 - 00)");
        }
        System.out.print("Minutes: ");
        int minutes = Integer.parseInt(scan.nextLine());
        if(minutes < 0 || minutes > 60){
            throw new DateCreationException("the minutes " + minutes + " is not in range(0 - 60)");
        }
        System.out.print("Seconds: ");
        int seconds = Integer.parseInt(scan.nextLine());
        if(seconds < 0 || seconds > 60){
            throw new DateCreationException("the seconds " + seconds + " is not in range(0 - 60)");
        }

        LocalDateTime newLocalDate = LocalDateTime.of(year, month, day ,hour, minutes, seconds);
        System.out.println("Please type the reminder's description");
        String des = scan.nextLine();

        System.out.println("Is the reminder important [1 - yes , 2 - no]");
        int impOption;
        do{
            System.out.println("please type [1 for yes or 2 for no]");
            impOption = Integer.parseInt(scan.nextLine());
        }while (impOption < 1 || impOption > 2);
        Reminder reminderToAdd = new Reminder(newLocalDate , des, (impOption == 1));
        try {
            rh.addReminder(reminderToAdd);
        } catch (ReminderAddException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        RemindersHolder reminderHolder = new RemindersHolder();
        String command;
        ReminderTask reminderTask = new ReminderTask(reminderHolder);
        reminderTask.start();

        lbl : while (true){
            command = Menu.showMenu();
            switch (command){
                case "add":{
                    try {
                        addReminder(reminderHolder);
                        System.out.println();
                        break;
                    } catch (DateCreationException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                }
                case "show":{
                    showReminders(reminderHolder);
                    break;
                }
                case "quit":{
                    System.out.println("Cya");
                    break lbl;
                }
                default:{
                    System.out.println("Please type a valid option!");
                }
            }
        }
        System.exit(0);
    }
}
