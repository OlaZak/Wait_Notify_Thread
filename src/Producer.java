import java.util.ArrayList;
import java.util.Date;

public class Producer extends Thread{

 ArrayList<String> messages = new ArrayList<>();

    @Override
    public void run() {
        while (true){
            try {
                putMessage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void putMessage() throws InterruptedException {
        while (messages.size() == 5) {
            wait(500);
            System.out.println("wait because message.size == 5");
        }
        messages.add(new Date().toString());
        System.out.println("put Message");
        notify();
    }

    public synchronized String getMessages() throws InterruptedException {
         notify();
            while (messages.size() ==0 ){
                wait(500);
                System.out.println("wait get");
            }
            String message = messages.get(0);
            messages.remove(message);
        System.out.println("delete message");
        return message;
    }
}
