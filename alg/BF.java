public class BF implements Strategy {
    String[] answer;
    boolean allotted;
    int diff;
    int tempMem;
    int tempMemSpace;
    int allottedCount;
    String tempAns;

    public String[] execute(Mallocator m){
        answer = new String[m.PID.length+1];
        allottedCount = m.PID.length;

        for(int i = 0; i<m.PID.length; i++) {
            diff = m.processSize[i];
            tempAns = null;
            allotted = false;
            for(int j = 0; j<m.PID.length; j++){
                if(m.calculateSize(j) - m.processSize[i] < diff  && m.processSize[i] < m.calculateSize(j)){
                    diff = m.calculateSize(j) - m.processSize[i];
                    tempAns = m.memoryStart[j] + " " + (m.memoryStart[j] + m.processSize[i]) + " " + m.PID[i];
                    tempMem = m.memoryStart[j] + m.processSize[j];
                    tempMemSpace = j;
                    allotted = true;
                }
            }
            if(allotted){
                answer[i] = tempAns;
                m.memoryStart[tempMemSpace] = tempMem;
                allottedCount--;
                if(allottedCount == 0)
                    answer[m.PID.length] = "-0";
            }
            if(!allotted)
                answer[i] = "-" + m.PID[i];
        }
        return answer;
    } 
}