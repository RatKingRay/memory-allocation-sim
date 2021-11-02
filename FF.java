public class FF implements Strategy {
    String[] answer;

    public String[] execute(Mallocator m){
        answer = new String[m.PID.length+1];

        //int answerCount = 0;

        for(int i = 0; i < m.PID.length; i++) {
            for(int j = 0; j < m.PID.length; j++){
                if(m.processSize[j] < m.calculateSize(j)) {
                    answer[i] = m.memoryStart[j] + " " + (m.memoryStart[j] + m.processSize[i]) + " " + m.PID[i];
                }
            }
        }
        return answer;
    } 
}