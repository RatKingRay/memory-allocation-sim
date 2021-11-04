public class WF implements Strategy {
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
            diff = 0;
            tempAns = null;
            allotted = false;
            for(int j = 0; j<m.PID.length; j++){
                System.out.println("in" + m.PID[i] + " Size: "+m.processSize[i]);
                System.out.println("diff is: " + diff);
                System.out.println("Next diff is: "+(m.calculateSize(j) - m.processSize[i]));
                System.out.println(m.memoryStart[j] + " " + m.memoryEnd[j]);
                if(m.calculateSize(j) - m.processSize[i] > diff && m.processSize[i] < m.calculateSize(j)){
                    System.out.println("here!");
                    diff = m.calculateSize(j) - m.processSize[i];
                    tempAns = m.memoryStart[j] + " " + (m.memoryStart[j] + m.processSize[i]) + " " + m.PID[i];
                    tempMem = m.memoryStart[j] + m.processSize[j];
                    tempMemSpace = j;
                    allotted = true;
                }
            }
            if(allotted){
                answer[i] = tempAns;
                m.memoryStart[tempMemSpace] = tempMem;  //Only problem is for some reason this is ending up adding 15 more and wrong
                allottedCount--;
            }
            if(!allotted)
                answer[i] = "-" + m.PID[i];
            if(allottedCount == 0)
                answer[m.PID.length] = "-0";
        }
        return answer;
    } 
}