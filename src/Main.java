import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static String fileName = "jibun_";
    static String resultFileName = "result.txt";
    public static void main(String[] args) {
        System.out.println("Hello World!");

        File f  = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());

        System.out.println(f.toString());
        List<String> results = new ArrayList<>();
        for(int i = 1; i<18;i++) {
            try {

                FileInputStream fIs = new FileInputStream(
                        Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"../../../data/"+fileName +i+".txt");

                InputStreamReader inputStreamReader = new InputStreamReader(fIs, "MS949");
                BufferedReader br = new BufferedReader(inputStreamReader);

                String curLine;
                while((curLine = br.readLine()) != null){

                    String [] dump = curLine.split("[|]");
                    String result = dump[1]+" "+dump[2]+" "+dump[3];

                    if (results.isEmpty()){
                        System.out.println(result);

                        results.add(result);
                    }else if(!results.contains(result)) {
                        System.out.println(result);


                        results.add(result);
                    }
                }



            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        try {
        System.err.println("count : "+results.size());
        String[] dumpArray = new String[results.size()];
        dumpArray = results.toArray(dumpArray);

        Arrays.sort(dumpArray, String.CASE_INSENSITIVE_ORDER);

        results.clear();
        for(String a: dumpArray)
            results.add(a);

        BufferedWriter out = new BufferedWriter(new FileWriter(resultFileName));

        for(String s : results){
            out.write(s);
            out.write("|");

        }
        out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
