public interface Strategy {
    String[] answer = null;
    public String[] execute(Mallocator m);
}