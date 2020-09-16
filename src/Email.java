/*
    Author : Ahmet Cemal Sert
 */

public class Email {

    private String subject;
    private String message;
    private int ID;
    private int time;
    private boolean flag;

    public Email(String subject, String message, int ID, int time) {
        this.subject = subject;
        this.message = message;
        this.ID = ID;
        this.time = time;
        this.flag = false;
    }


    public int getID() {
        return ID;
    }


    public String getMessage() {
        return message;
    }


    public String getSubject() {
        return subject;
    }


    public int getTime() { return time; }

    public boolean getFlag() {
        return flag;
    }


    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    @Override
    public String toString() {
        String mailString = "Email ID :" + this.ID + "\n" +
                            "Subject:" + this.subject + "\n" +
                            "Body:" + this.message + "\n" +
                            "Time received:"+ this.time + "\n" +
                            "Status:"+ this.flag+ "\n";
        return mailString;
    }
}