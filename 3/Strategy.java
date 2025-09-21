interface IStrategy {
    void display(int number);
}

class StrategyFirst implements IStrategy {
    private String name;

    public StrategyFirst(String name) {
        this.name = name;
    }

    @Override
    public void display(int number) {
        System.out.println("Стратегия:" + name + ". Число:" + number);
    }
}

class StrategySecond implements IStrategy {
    private String name;

    public StrategySecond(String name) {
        this.name = name;
    }

    @Override
    public void display(int number) {
        System.out.println("Стратегия:" + name + ". Число:" + number);
    }
}

public class Strategy {
    private IStrategy strategy;

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void out(int number) {
        strategy.display(number);
    }

    public static void main(String[] args) {
        Strategy context = new Strategy();

        // Устанавливаем первую стратегию
        context.setStrategy(new StrategyFirst("Первая"));
        context.out(10);

        // Меняем на вторую стратегию
        context.setStrategy(new StrategySecond("Вторая"));
        context.out(20);
    }
}