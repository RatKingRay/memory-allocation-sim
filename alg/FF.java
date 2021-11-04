public class FF implements Strategy {
    String[] answer;
    boolean allotted;
    int allottedCount;


    public String[] execute(Mallocator m){
        answer = new String[m.PID.length+1];
        allottedCount = m.PID.length;

        for(int i = 0; i<m.PID.length; i++) {
            allotted = false;
            for(int j = 0; j<m.PID.length; j++){
                if(m.processSize[i] < m.calculateSize(j)) {
                    answer[i] = m.memoryStart[j] + " " + (m.memoryStart[j] + m.processSize[i]) + " " + m.PID[i];
                    m.memoryStart[j] = m.memoryStart[j] + m.processSize[j];
                    allottedCount--;
                    allotted = true;
                    break;
                }
            }
            if(!allotted)
                answer[i] = "-" + m.PID[i];
            if(allottedCount == 0)
                answer[m.PID.length] = "-0";
        }
        return answer;
    } 
}