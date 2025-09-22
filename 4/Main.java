public class Main {
    public static final Object object1 = new Object();
    public static final Object object2 = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            synchronized (object1) {
                System.out.println("Поток 1, захватил Объект 1");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
                System.out.println("Поток 1 пытается захватить Объект 2");
                synchronized (object2) {
                    System.out.println("Поток 1 захватил оба объекта");
                }
            }
        }
        );
        Thread thread2 = new Thread(() -> {
            synchronized (object2) {
                System.out.println("Поток 2 захватил объект 2");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
                System.out.println("Поток 2 пытается захватить объект 1");
                synchronized (object1) {
                    System.out.println("ПОток 2 захватил оба объекта");
                }
            }
        });

        //Для задания с DeadLock
        //thread1.start();
        //thread2.start();


        //Для задания с LiveLock
        final LiveLock lock1 = new LiveLock("Поток 1", true);
        final LiveLock lock2 = new LiveLock("Поток 2", true);

        new Thread(()->lock1.tryToGo(lock2)).start();
        new Thread(()-> lock2.tryToGo(lock1)).start();


        //Для задания №2 с бесконечным выводом 1 и 2
        /*Counting count1 = new Counting("1");
        Counting count2 = new Counting("2");

        new Thread(()-> count1.letPrint1()).start();
        new Thread(()->count2.letPrint2()).start();*/
    }
}