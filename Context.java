public class Context {
    private Strategy strategy;
    private Mallocator mallocator;

    public Context(Strategy s, Mallocator m) {
        this.strategy = s;
        this.mallocator = m;
    }

    public void setStrategy(Strategy s){
        this.strategy = s;
    }

    public String[] executeStrategy(){
        String[] temp = strategy.execute(mallocator);
        return temp;
    }
}
