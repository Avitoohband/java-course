import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Reminder implements Comparable<Reminder>{
    public static final int COMPARE_ERROR = -99;

    private LocalDateTime ldt;
    private String desc;
    private boolean isImportant;
    private boolean alreadyShowed;

    public Reminder(LocalDateTime ldt, String desc, boolean isImportant) {
        this.ldt = ldt;
        this.desc = desc;
        this.isImportant = isImportant;
        alreadyShowed = false;
    }
    public void setAlreadyShowed(){
        alreadyShowed = true;
    }


    @Override
    public int compareTo(Reminder other){
        if (other == null) {
            System.out.println("Cannot compare with Reminder and " + null);
            return COMPARE_ERROR;
        }
        return ldt.compareTo(other.getLdt());
    }

    public LocalDateTime getLdt() {
        return ldt;
    }

    @Override
    public String toString() {
         String fd = getFormattedDate();
        return  "Date: " + fd +
                ", Description: '" + desc  +
                ", is important: " + isImportant +
                ", popped alert: " + alreadyShowed  + "\n";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reminder reminder = (Reminder) o;
        return ldt.equals(reminder.ldt) && desc.equals(reminder.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ldt, desc, isImportant, alreadyShowed);
    }

    public boolean isImportant() {
        return isImportant;
    }

    public boolean isAlreadyShowed() {
        return alreadyShowed;
    }
    public String getFormattedDate(){
        DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return ldt.format(formatter);
    }
}
