import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class RemindersHolder {

    Set<Reminder> remSet;

    public RemindersHolder(){
        remSet = new TreeSet<>();
    }

    public void addReminder(Reminder remToAdd) throws ReminderAddException{
        if(remSet.add(remToAdd)){
            if(remToAdd.getLdt().isBefore(LocalDateTime.now())){
                remSet.remove(remToAdd);
                throw new ReminderAddException("Cannot add Reminders that it's time has passed " + remToAdd.getFormattedDate());
            }
            System.out.println("Successfully add the desired reminder");
        }else{
            throw new ReminderAddException("Cannot add duplicated Reminders!");
        }
    }
    public void showReminders(){
        if (remSet.size() == 0){
            System.out.println("There is no reminders available to show!");
            return;
        }
        for (Reminder reminder : remSet) {
            System.out.println(reminder);
        }
    }

    public Set<Reminder> getRemSet() {
        return remSet;
    }
}

