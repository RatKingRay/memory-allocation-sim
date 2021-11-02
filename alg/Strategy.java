public interface Strategy {
    String[] answer = null;
    boolean allotted = false;
    public String[] execute(Mallocator m);
}