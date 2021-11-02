public class BF implements Strategy {
    String[] answer;
    boolean allotted;
    int diff = 0;

    public String[] execute(Mallocator m){
        answer = new String[m.PID.length+1];

        for(int i = 0; i<m.PID.length; i++) {
            allotted = false;
            for(int j = 0; j<m.PID.length; j++){
                if(diff < m.calculateSize(j) - m.processSize[i] && m.processSize[i] < m.calculateSize(j)){
                    diff = m.calculateSize(j) - m.processSize[i];
                    answer[i] = m.memoryStart[j] + " " + (m.memoryStart[j] + m.processSize[i]) + " " + m.PID[i];
                    m.memoryStart[j] = m.memoryStart[j] + m.processSize[j];
                    allotted = true;
                }
/*                 if(m.processSize[i] < m.calculateSize(j)) {
                    answer[i] = m.memoryStart[j] + " " + (m.memoryStart[j] + m.processSize[i]) + " " + m.PID[i];
                    m.memoryStart[j] = m.memoryStart[j] + m.processSize[j];
                    allotted = true;
                    break;
                } */
            }
            if(!allotted)
                answer[i] = "-" + m.PID[i];
        }
        return answer;
    } 
}