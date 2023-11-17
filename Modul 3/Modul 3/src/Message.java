public class Message {
    String content;
    String sender;
    String time;

    public Message(String content, String sender) {
        this.content = content;
        this.sender = sender;
        this.time = "12:00";
    }
    public String getContent() {
        return content;
    }
    public String getSender() {
        return sender;
    }
    public String getTime() {
        return time;
    }
}
