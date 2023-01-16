import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class OracleStuff extends Task {
    int n;
    int m;
    int k;
    ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    ArrayList<ArrayList<Integer>> data = new ArrayList<>();

//    public static void generateOracleInput(int n, int m, int k, ArrayList<ArrayList<Integer>> matrix,
//                                           ArrayList<ArrayList<Integer>> data) throws IOException {
//        FileWriter fileWriter = new FileWriter("sat.cnf");
////        int clau = n + k + (m - 1) * m / 2 * k + (k - 1) * k / 2 * m;
//        int clau = m * k;
//        fileWriter.write("p cnf " + m * k + " " + clau + "\n");
//
//        for (int i = 0; i < k; ++i) {
//            for (int j = 1; j <= m; ++j) {
//                fileWriter.write(j + i * m + " ");
//            }
//            fileWriter.write("0\n");
//        }
//
//        int aux;
//        for (int contor = 1; contor <= n; ++contor) {
//            for (int i = 1; i <= m; ++i) {
//                for (int j = 1; j <= data.get(i - 1).get(0); ++j) {
//                    if (contor == data.get(i - 1).get(j)) {
//                        aux = i;
//                        fileWriter.write(aux + " ");
//                        for (int ceva = 1; ceva < k; ++ceva) {
//                            aux += m;
//                            fileWriter.write(aux + " ");
//                        }
//                        break;
//                    }
//                }
//            }
//            fileWriter.write("0\n");
//        }
//
//        fileWriter.close();
//    }

    public static void callOracle() {

    }

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

        for (int i = 0; i < n; ++i) {
            matrix.add(new ArrayList<>());
        }

        for (int i = 0; i < m; ++i) {
            tokenizer = new StringTokenizer(bf.readLine());
            int l = Integer.parseInt(tokenizer.nextToken());
            data.add(new ArrayList<Integer>());
            data.get(i).add(l);
            for(int j = 1; j <= l; ++j) {
                int val = Integer.parseInt(tokenizer.nextToken());
                data.get(i).add(val);
            }
        }
    }

    @Override
    public void formulateOracleQuestion() throws IOException {
        FileWriter fileWriter = new FileWriter("sat.cnf");
//        int clau = n + k + (m - 1) * m / 2 * k + (k - 1) * k / 2 * m;
        int clau = m * k;
        fileWriter.write("p cnf " + m * k + " " + clau + "\n");

        for (int i = 0; i < k; ++i) {
            for (int j = 1; j <= m; ++j) {
                fileWriter.write(j + i * m + " ");
            }
            fileWriter.write("0\n");
        }

        int aux;
        for (int contor = 1; contor <= n; ++contor) {
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= data.get(i - 1).get(0); ++j) {
                    if (contor == data.get(i - 1).get(j)) {
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

    }

    @Override
    public void writeAnswer() throws IOException {

    }
}
