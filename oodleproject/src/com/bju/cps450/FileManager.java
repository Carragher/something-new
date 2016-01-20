package com.bju.cps450;

import java.io.*;
import java.util.List;

/**
 * Created by carragher on 1/18/16.
 */
public class FileManager {

    public static String[] initArray;
    public static FileReader read;
    public static File file;
    public static List<Integer> iList;
    public static List<String> sList;
    public static FileWriter fw;











    public static void generateTemp() throws IOException {

        try {
             file = File.createTempFile("temp",".tmp");
            fw = new FileWriter(file);

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String filename : initArray){
            // open file
            //write to temp file
            //save line numbers for the extra credit
            // savefile name

            try {
                BufferedReader read = new BufferedReader(new FileReader(filename));
                BufferedWriter write = new BufferedWriter(fw);
                String sCurrentLine;

                int lineInc = 0;
                while((sCurrentLine = read.readLine()) != null){
                    write.write(sCurrentLine + "\n");
                    lineInc = lineInc + 1;
                }

                iList.add(lineInc);
                sList.add(filename);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }





        }

    }
    //temp files how


}
