interface IMessage{
    void display();
}
class Real implements IMessage{
    private String name;
    public Real(String name){
        this.name = name;
    }
    @Override
    public void display(){
        System.out.println("Исходное сообщение" + name);
    }
}
class Proxy implements IMessage {
    private Real real;
    private String name;
    public Proxy(String name){
        this.name = name;
    }
    @Override
    public void display(){
        if (real == null){
            real = new Real(name);
        }
        real.display();
    }
}
class Main3{
    public static void main(String[] args){
        Proxy proxy = new Proxy("(Прокси)");
        proxy.display();
    }
}