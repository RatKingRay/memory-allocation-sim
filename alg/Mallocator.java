import java.util.*;
import java.io.*;
import java.lang.*;

class Mallocator{
    int[] memoryStart;
    int[] memoryEnd;
    int[] PID;
    int[] processSize; 
    
    public Scanner setMScanner(){
        try {
            Scanner mInput = new Scanner (new File("E:/code/memory-allocation-sim/data/Minput.data"));
            return mInput;
        } catch (Exception e) {
            //TODO: handle exception
        }
        return null;
    }

    public Scanner setPScanner(){
        try {
            Scanner pInput = new Scanner(new File("E:/code/memory-allocation-sim/data/Pinput.data"));
            return pInput;
        } catch (Exception e) {
            //TODO: handle exception
        }
        return null;
    }

    public void fillMArray(){
        Scanner mInput = setMScanner();
        int mMax = Integer.parseInt(mInput.next()); //Initializing Arrays with how many memory slots there are
        memoryStart = new int[mMax];
        memoryEnd = new int[mMax];

        for(int i = 0; mInput.hasNext(); i++) { //Allocating memory to arrays
            memoryStart[i] = mInput.nextInt();
            memoryEnd[i] = mInput.nextInt();
        }
    }

    void printMArray(){
        for(int i = 0; i < memoryStart.length; i++){
        System.out.println("Memory slot " + i);
        System.out.println(memoryStart[i] + " " + memoryEnd[i]);
        }
    }

    public void fillPArray(){
        Scanner pInput = setPScanner();             //Initalizing Scanner

        int pMax = Integer.parseInt(pInput.next()); //Initializing Arrays with how many memory slots there are
        PID = new int[pMax];
        processSize = new int[pMax];

        for(int i = 0; pInput.hasNext(); i++) { //Allocating memory to arrays
            PID[i] = pInput.nextInt();
            processSize[i] = pInput.nextInt();
        }
    }

    public void printPArray(){
        for(int i = 0; i < PID.length; i++){
            System.out.println("PID:" + PID[i]);
            System.out.println(processSize[i]);
        }
    }

    

    public int calculateSize(int x){
        return memoryEnd[x] - memoryStart[x];
    }

    public void writeAnswer(String[] a, String f){
        try {
            FileWriter fw = new FileWriter(new File(f));
            for (int i = 0; i < a.length; i++) {
                if(a[i] == null)
                    break;
                fw.write(a[i] + '\n');
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public void runFF(Mallocator m){
        Context context = new Context(new FF(), m);
        String[] temp = context.executeStrategy();

        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
        writeAnswer(temp, "FFoutput.data");
    }

    public void runBF(Mallocator m){
        Context context = new Context(new BF(), m);
        String[] temp = context.executeStrategy();
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
        writeAnswer(temp, "BFoutput.data");
    }

    public void runWF(Mallocator m){
        Context context = new Context(new WF(), m);
        String[] temp = context.executeStrategy();
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }

}