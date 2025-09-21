interface EUPlug {
    void powerEU();
}

class USPlug {
    void powerUS() {
        System.out.println("Американская розетка");
    }
}

class USToEUAdapter extends USPlug implements EUPlug {
    @Override
    public void powerEU() {
        powerUS();
    }
}

public class Adapter {
    public static void main(String[] args) {
        USToEUAdapter us2eu = new USToEUAdapter();
        us2eu.powerEU();
        us2eu.powerUS();
    }
}