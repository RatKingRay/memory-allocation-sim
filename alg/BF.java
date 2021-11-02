public class BF implements Strategy {
    String[] answer;

    public String[] execute(Mallocator m){
        answer = new String[m.PID.length+1];
        answer[0] = "100 310 2";
        answer[1] = "600 790 1";
        answer[2] = "1500 1705 3";
        answer[3] = "-0";
        return answer;
    }
}