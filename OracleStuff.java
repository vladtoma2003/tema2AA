import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class OracleStuff extends Task {
    int n;
    int m;
    int k;
    ArrayList<ArrayList<Integer>> data = new ArrayList<>();
    ArrayList<ArrayList<Integer>> clau = new ArrayList<>();
    ArrayList<Integer> ref = new ArrayList<>();
    Boolean ans = false;

    @Override
    public void solve() throws IOException, InterruptedException {

    }

    @Override
    public void readProblemData() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < m; ++i) {
            tokenizer = new StringTokenizer(bf.readLine());
            int l = Integer.parseInt(tokenizer.nextToken());
            clau.add(new ArrayList<Integer>());
            clau.get(i).add(l);
            for (int j = 1; j <= l; ++j) {
                int val = Integer.parseInt(tokenizer.nextToken());
                clau.get(i).add(val);
            }
        }
        bf.close();
    }

    @Override
    public void formulateOracleQuestion() throws IOException {
        FileWriter fileWriter = new FileWriter("sat.cnf");
        int nrClauses = m * k + n + k + m * (m - 1) / 2 * k; // toate clauzele pentru unicitatea
        // pe linii
        fileWriter.write("p cnf " + m * k + " " + nrClauses + "\n");

        for (int i = 0; i < k; ++i) { // primul set
            data.add(new ArrayList<>());
            for (int j = 1; j <= m; ++j) {
                data.get(i).add(j + i * m);
                fileWriter.write(data.get(i).get(j - 1) + " ");
            }
            fileWriter.write("0\n");
        }

        for (int big = 0; big < k; ++big) { // al doilea set
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (i == j) {
                        continue;
                    }
                    fileWriter.write("-" + data.get(big).get(i) + " -" + data.get(big).get(j) +
                            " " + "0\n");
                }
            }
        }

        int aux;
        for (int big = 1; big <= n; ++big) { // al treilea set
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= clau.get(i - 1).get(0); ++j) {
                    if (big == clau.get(i - 1).get(j)) {
                        aux = i;
                        fileWriter.write(aux + " ");
                        for (int ceva = 1; ceva < k; ++ceva) {
                            aux += m;
                            fileWriter.write(aux + " ");
                        }
                        break;
                    }
                }
            }
            fileWriter.write("0\n");
        }

        fileWriter.close();
    }

    @Override
    public void decipherOracleAnswer() throws IOException {
        FileReader fileReader = new FileReader("sat.sol");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String gogu = stringTokenizer.nextToken();

        if (gogu.equals("True")) {
            ans = true;
        }
        if (!ans) {
            return;
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        gogu = stringTokenizer.nextToken();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int max = Integer.parseInt(gogu);
        for (int i = 0; i < max; ++i) {
            gogu = stringTokenizer.nextToken();
            int nrGogu = Integer.parseInt(gogu);
            if (nrGogu > 0) {
                ref.add((nrGogu % m) != 0 ? nrGogu % m : ((nrGogu < n) ? nrGogu : m));
            }
        }
        Collections.sort(ref);

        fileReader.close();
        bufferedReader.close();
    }

    @Override
    public void writeAnswer() throws IOException {
        if (!ans) {
            System.out.println("False");
        } else {
            System.out.println("True");
            System.out.println(k);
            ref.stream().forEach(o -> System.out.print(o + " "));
        }
        System.out.println();
    }

    public void setArrays(ArrayList<Integer> dataSize, ArrayList<ArrayList<Integer>> values) {
        n = dataSize.get(0);
        m = dataSize.get(1);
        k = dataSize.get(2);

        clau = values;

    }
}
