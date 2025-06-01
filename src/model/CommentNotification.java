package model;

public class CommentNotification implements Notification {
    private String fromUser;
    private String toUser;
    private String comment;

    public CommentNotification(String fromUser, String toUser, String comment) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.comment = comment;
    }

    @Override
    public void send() {
        System.out.println(fromUser + " commented: '" + comment + "' on " + toUser + "'s post.");
    }
}