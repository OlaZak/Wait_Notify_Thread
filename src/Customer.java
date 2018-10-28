public class Customer extends Thread {

    Producer producer;

    Customer(Producer p){
        producer = p;
    }

    @Override
    public void run() {

        while (true){
            try {
              String  message = producer.getMessages();
                System.out.println("Message " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
