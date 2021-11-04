public class mainClass{
    public static void main(String[] args){
        Mallocator mallocator = new Mallocator();
        mallocator.fillMArray();
        mallocator.printMArray();

        System.out.println();

        mallocator.fillPArray();
        mallocator.printPArray();
        System.out.println("");
        //mallocator.runFF(mallocator);
        mallocator.runBF(mallocator);

/*         String[] temp0;
        String[] temp1;
        String[] temp2;
        FF ff = new FF();
        temp0 = ff.execute(mallocator);
        for(int i = 0; i < ff.answer.length; i++) {
            System.out.println(ff.answer[i]);
        }

        BF bf = new BF();
        temp1 = bf.execute(mallocator);
        for(int i = 0; i < bf.answer.length; i++) {
            System.out.println(bf.answer[i]);
        }

        WF wf = new WF();
        temp2 = wf.execute(mallocator);
        for(int i = 0; i < wf.answer.length; i++) {
            System.out.println(wf.answer[i]);
        } */
        
       /*  try {
            FileWriter ffFw = new FileWriter("FFoutput.data");
            FileWriter bfFw = new FileWriter("BFoutput.data");
            FileWriter wfFw = new FileWriter("WFoutput.data");
            for(int i = 0; i < 3; i++) {
                ffFw.write(ff.answer[i]);
                ffFw.write("\n");
            }
            ffFw.flush();
            ffFw.close();

            for(int i = 0; i < 4; i++) {
                bfFw.write(bf.answer[i]);
                bfFw.write("\n");
            }
            bfFw.flush();
            bfFw.close();

            for(int i = 0; i < 4; i++) {
                wfFw.write(wf.answer[i]);
                wfFw.write("\n");
            }
            wfFw.flush();
            wfFw.close();

        } catch (Exception e) {
            //TODO: handle exception
        }
 */
    }
}