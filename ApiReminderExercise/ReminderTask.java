import java.time.LocalDateTime;
import java.util.Set;

public class ReminderTask extends Thread{

    public static final int IMT_NOTE_TIMES = 2;
    public static final int IMT_THREAD_SLEEP = 60000;
    public static final int CHECK_EVEY_SECOND = 1000;
    RemindersHolder reminders;

    public ReminderTask(RemindersHolder reminders) {
        this.reminders = reminders;
        setDaemon(true);
    }
    @Override
    public void run() {
        super.run();
        while(true){
            try {
                sleep(CHECK_EVEY_SECOND);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Set<Reminder> remSet = reminders.getRemSet();
            for (Reminder reminder : remSet) {
                if(reminder.getLdt().isBefore(LocalDateTime.now())){
                    if (reminder.isAlreadyShowed()){
                        continue;
                    }
                    if (reminder.isImportant()){
                        noteImportantReminder(reminder);
                    }else
                    {
                        noteReminder(reminder);

                    }
                    reminder.setAlreadyShowed();
                }
            }
        }
    }
    private void noteReminder(Reminder r){
        System.out.println("\nALERT! for task: " + r);
    }
    private void noteImportantReminder(Reminder r){
        Thread impRemThread = new Thread(){
            @Override
            public void run() {
                super.run();
                System.out.println("\nIMPORTANT ALERT! for task: " + r);
                for (int i = 0; i < IMT_NOTE_TIMES; i++) {
                    try {
                        Thread.sleep(IMT_THREAD_SLEEP);
                        System.out.println("\nIMPORTANT ALERT! for task: " + r);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        impRemThread.setDaemon(true);
        impRemThread.start();
    }
}
