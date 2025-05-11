import java.io.*;

public class FileStats {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int vowels = 0, words = 0, aCount = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] w = line.split("\\s+");
            words += w.length;
            for (char c : line.toLowerCase().toCharArray()) {
                if ("aeiou".indexOf(c) != -1) vowels++;
                if (c == 'a') aCount++;
            }
        }
        br.close();
        System.out.println("Vowels: " + vowels);
        System.out.println("Words: " + words);
        System.out.println("'a' count: " + aCount);
    }
}
