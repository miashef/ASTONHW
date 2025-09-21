interface ISource {
    void write(String src);

    String read();
}

class Message implements ISource {
    private String msg;

    public Message() {

    }

    @Override
    public void write(String src) {
        System.out.println("Данные: " + src);
        this.msg = src;
    }

    @Override
    public String read() {
        return msg;
    }
}

class Decorator implements ISource {
    private ISource source;

    public Decorator(ISource source) {
        this.source = source;
    }

    @Override
    public void write(String src) {
        source.write(src.getBytes().toString());
    }

    @Override
    public String read() {
        return source.read();
    }
}

class Main4 {
    public static void main(String[] args) {
        ISource source = new Decorator(new Message());
        source.write("Привет мир!");

    }
}