public class Event extends Task {
    private String time;

    public Event(String item, int index, String time) {
        super(item, index);
        this.time = time;
    }

    @Override
    public void printTask() {
        super.printTask();
        System.out.print(" (at: " + this.getTime() + ")");
    }

    public String getTime() {
        return time;
    }
}