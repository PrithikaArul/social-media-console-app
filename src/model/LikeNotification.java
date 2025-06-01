package model;

public class LikeNotification implements Notification{
    private String fromUser;
    private String toUser;
    private String postTitle;

    public LikeNotification(String fromUser, String toUser, String postTitle) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.postTitle = postTitle;
    }

    @Override
    public void send() {
        System.out.println(fromUser + " liked your post '" + postTitle + "', " + toUser + "!");
    }
}
