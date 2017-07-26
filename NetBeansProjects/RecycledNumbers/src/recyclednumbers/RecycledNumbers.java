package recyclednumbers;

import java.util.*;
import java.io.*;

/*
 * @author :Serge Jabo Byusa
 * Interning :Pivot Access
 * Coding Question #5: Recycled Numbers 
 */
public class RecycledNumbers {

    final static String inputFile = "/home/serge/NetBeansProjects/RecycledNumbers/src/recyclednumbers/in.txt";
    final static String outPutFile = "/home/serge/NetBeansProjects/RecycledNumbers/src/recyclednumbers/out.txt";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new FileReader(inputFile)); //use the scanner and file reader to get the input from the File
        PrintWriter pw = new PrintWriter(new FileWriter(outPutFile)); //use the printwriter to print in the outfile
        int NumOfCases = sc.nextInt(); //read the number of cases at the begining of the file
        for (int caseCount = 0; caseCount < NumOfCases; caseCount++) {
            pw.print("Case #" + (caseCount + 1) + ": "); //print  the string "case #" and the case number starting from 1
            new RecycledNumbers().recycles(sc, pw);   //call the method to help print
        }
        pw.flush();
        pw.close();
        sc.close();
    }

    void recycles(Scanner sc, PrintWriter pw) {
        int A = sc.nextInt(); //smaller number to start with (eg:10)
        int B = sc.nextInt();//bigger number to end with (eg:40)
        int res = 0;
        for (int number = A; number <= B; number++) { //loop from that smaller number to the bigger number (eg: from 10 to 40)
            String s = "" + number; //get each number (in that range) then make it a string (eg: int n =12 becomes String s = "12")
            Set<Integer> recycleList = new HashSet<>(); //create a hashset to store those numbers
            for (int st = 1; st < s.length(); st++) {//loop from one till the less than of the length of each number(eg: )
                //use the substring method to get part of the string
                String ss = s.substring(st) + s.substring(0, st);// get each part of the string and add it to the other one removing zero (eg: ss = "1" + "2")
                int m = Integer.parseInt(ss); //turn that concatanted string into an integer
                if (number < m && m >= A && m <= B) //check if the original number is less than the concatened number and is between the limit given
                {
                    recycleList.add(m); //if so add it to the hashset
                }
            }
            res += recycleList.size(); //increment the size of the recycleList
        }
        pw.println(res); //print the number of recycles in that range
    }
}
