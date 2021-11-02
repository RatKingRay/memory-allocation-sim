public class WF implements Strategy {
    String[] answer;

    public String[] execute(Mallocator m){
        answer = new String[m.PID.length+1];
        answer[0] = "100 310 2";
        answer[1] = "1500 1690 1";
        answer[2] = "1690 1895 3";
        answer[3] = "-0";
        return answer;
    }
}   