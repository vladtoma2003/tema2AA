import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        System.out.println(n);
        System.out.println(m);
        System.out.println(k);

        BufferedWriter w = new BufferedWriter(new FileWriter("output.txt"));
        String ns = Integer.toString(n);
        String ms = Integer.toString(m);
        String ks = Integer.toString(k);

        String out = ns + ' ' + ms + ' ' + ks;
        w.append(out);
        w.close();
    }
}