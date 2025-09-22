public class LiveLock {
    private String name;
    private boolean movingR;
    private boolean letOtherPass;

    public LiveLock(String name, boolean movingR) {
        this.name = name;
        this.movingR = movingR;
        this.letOtherPass = false;
    }

    public void tryToGo(LiveLock other) {
        while (!passSuccess(other)) {
            System.out.println(name + " Двигаюсь " + (movingR ? "вправо" : "влево"));
            if(other.letOtherPass){
                movingR = !movingR;
                System.out.println(name + "Меняю направление на "+ (movingR ? "право" : "лево"));
            }
           try {
                //Thread.sleep((long) (Math.random() * 500));
               Thread.sleep(50);
            } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
               return;
            }
            letOtherPass = !letOtherPass;
        }
        System.out.println(name + "успешно прошёл!");
    }

    public boolean passSuccess(LiveLock other) {
        return (this.movingR != other.movingR) ||
                (this.letOtherPass != other.letOtherPass);
    }
}