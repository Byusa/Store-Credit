/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storecredit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author serge
 */
public class StoreCredit {

    /**
     * @param args the command line arguments
     */
    public static int addChecki(int list[], int Cost) {
        int pos1 = 0;
        for (int i = 0; i < list.length; i++) {
            //System.out.println(" 1st list "+list[i]);
            for (int j = 0; j < list.length; j++) {
                //System.out.println(" 2nd list "+list[j]);
                if ((list[i] + list[j] == Cost) && (i != j)) {
                    pos1 = i + 1;
                    return pos1;
                }
            }
        }
        return pos1;
    }

    public static int addCheckj(int list[], int Cost) {
        int pos2 = 0;
        for (int i = 0; i < list.length; i++) {
            //System.out.println(" 1st list "+list[i]);
            for (int j = 0; j < list.length; j++) {
                //System.out.println(" 2nd list "+list[j]);
                if ((list[i] + list[j] == Cost) && (i != j)) {
                    pos2 = j + 1;
                    return pos2;
                }
            }
        }
        return pos2;
    }


    /*public static void main(String[] args)  {
        int list [] = {5, 25, 75};
        int pos= addCheck(list);
        System.out.println(pos);
        
    }*/
    public static void main(String[] args) throws IOException {
        // TODO code application logic herechar current;
        int i = 0, j = 1, k, d = 0, c = 1;
        BufferedReader br = null;
        BufferedWriter bw = null;
        FileInputStream fis = null;

        try {
            File in = new File("/home/serge/NetBeansProjects/StoreCredit/src/storecredit/in.txt");
            File out = new File("/home/serge/NetBeansProjects/StoreCredit/src/storecredit/out.txt");
            br = new BufferedReader(new FileReader(in));
            bw = new BufferedWriter(new FileWriter(out));
            fis = new FileInputStream(in);
            char current = ' ';
            String readLine = " ";
            String readLine2 = " ";
            String readLine3 = " ";
            int Cost = 0;
            int Items = 0;

            String rd = br.readLine();	 //read the first line and turn it into integer
            k = Integer.parseInt(rd);
            int list[] = new int[2000];
            if (!in.exists()) {
                System.out.print("The File Do not exist");
            }
            bw.write("Case #" + 1 + ": ");
            int p = 1;
            while (((readLine3 = br.readLine()) != null) && (p <= k * 3)) {
                readLine2 = br.readLine();
                readLine = br.readLine();
                String[] split = readLine.split(" ");
                String[] split2 = readLine2.split(" ");
                String[] split3 = readLine3.split(" ");
                String result = "";
                String result2 = split2[0];
                String result3 = split3[0];

                Cost = Integer.parseInt(result3);
                Items = Integer.parseInt(result2);
                int size = split.length;
                int list2[] = new int[split.length];
                for (i = 0; i < split.length; i++) {
                    result += (split[i]);
                    if (result != " ") {
                        list[i] = Integer.parseInt(result);
                        list2[i] = list[i];
                    }
                    result = "";
                }
                int ans1 = addChecki(list2, Cost);
                int ans2 = addCheckj(list2, Cost);
                if ((j > 1) && (j <= k)) {

                    if (ans1 < ans2) {
                        bw.write("\n" + "Case #" + j + ": " + ans1 + " " + ans2);
                    }else{
                        bw.write("\n" + "Case #" + j + ": " + ans2 + " " + ans1);
                    }
                }
                else if(j==1){
                    if (ans1 < ans2) {
                        bw.write(""+ans1 + " " + ans2);
                    }else{
                        bw.write(""+ans2 + " " + ans1);
                    }    
                }
                j++;
                p++;

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print(e);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }

}
