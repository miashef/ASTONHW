public class Counting {
    private String message;
    private static volatile boolean canIGo = true;
    private static final Object lock = new Object();
    Counting(String name){
        this.message = name;
    }
    public void letPrint1(){
        while(true){
            synchronized (lock) {
                    while (!canIGo) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.println(message);
                    canIGo = false;
                    lock.notifyAll();
            }
        }
    }
    public void letPrint2(){
        while(true){
            synchronized (lock) {
                while (canIGo) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.println(message);
                canIGo = true;
                lock.notifyAll();
            }
        }
    }

}