import java.util.*;
import java.io.*;

class Mallocator{
    int[] memoryStart;
    int[] memoryEnd;
    int[] PID;
    int[] processSize;
    
    public Scanner setMScanner(){
        try {
            Scanner mInput = new Scanner (new File("Minput.data"));
            return mInput;
        } catch (Exception e) {
            //TODO: handle exception
        }
        return null;
    }

    public Scanner setPScanner(){
        try {
            Scanner pInput = new Scanner(new File("Pinput.data"));
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

    public void runFF(Mallocator m){
        Context context = new Context(new FF(), m);
        String[] temp = context.executeStrategy();

        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }

    public void runBF(Mallocator m){
        Context context = new Context(new BF(), m);
        String[] temp = context.executeStrategy();
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }

    public void runWF(Mallocator m){
        Context context = new Context(new WF(), m);
        String[] temp = context.executeStrategy();
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }

}