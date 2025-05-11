import java.io.*;
import java.util.*;

public class FileEditor {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;
        File f = new File(args[0]);
        Scanner sc = new Scanner(System.in);
        if (f.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String l;
            while ((l = br.readLine()) != null)
                System.out.println(l);
            br.close();
            System.out.print("Do you want to add data to the end of the file? ");
            if (sc.nextLine().equalsIgnoreCase("Yes")) {
                FileWriter fw = new FileWriter(f, true);
                while (true) {
                    String s = sc.nextLine();
                    if (s.equals("exit")) break;
                    fw.write(s + "\n");
                }
                fw.close();
            }
        } else {
            FileWriter fw = new FileWriter(f);
            while (true) {
                String s = sc.nextLine();
                if (s.equals("exit")) break;
                fw.write(s + "\n");
            }
            fw.close();
        }
        sc.close();
    }
}
