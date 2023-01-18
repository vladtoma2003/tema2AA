import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class RiseStuff extends Task {
    int n;
    int m;
    int p;
    ArrayList<String> ownedCards = new ArrayList<>();
    ArrayList<String> desiredCards = new ArrayList<>();
    ArrayList<ArrayList<String>> decks = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<Integer> dataSize = new ArrayList<>();
    ArrayList<ArrayList<Integer>> codedValues = new ArrayList<>();
    int value = 1;
    int maxValue;
    int decksNo;
    int k;
    ArrayList<Integer> ref = new ArrayList<>();

    @Override
    public void solve() throws IOException, InterruptedException {
        dataSize.add(0);
        int i = 1;
        do{
            dataSize.set(2, i);
            OracleStuff oracle = new OracleStuff();
            oracle.setArrays(dataSize, codedValues);
            oracle.formulateOracleQuestion();
            oracle.askOracle();
            FileReader fileReader = new FileReader("sat.sol");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String gogu = stringTokenizer.nextToken();

            if (gogu.equals("True")) {
                k = i;
//                System.out.println(k);
                fileReader.close();
                break;
            }
            fileReader.close();
            ++i;
        }while (i <= decksNo);
    }

    @Override
    public void readProblemData() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(tokenizer.nextToken()); // nr of owned cards
        m = Integer.parseInt(tokenizer.nextToken()); // nr of wanted cards
        p = Integer.parseInt(tokenizer.nextToken()); // nr of decks

        for (int i = 0; i < n; ++i) {
            String currentCard = bf.readLine();
            if (!ownedCards.contains(currentCard)) {
                ownedCards.add(currentCard);
            }
        }

        for (int i = 0; i < m; ++i) {
            String currentCard = bf.readLine();
            if (!ownedCards.contains(currentCard)) {
                desiredCards.add(currentCard);
                map.putIfAbsent(currentCard, value);
                ++value;
            }
        }

        for (int i = 0; i < p; ++i) {
            decks.add(new ArrayList<String>());
            tokenizer = new StringTokenizer(bf.readLine());
            int nrOfCardsInDeck = Integer.parseInt(tokenizer.nextToken());
            for (int j = 0; j < nrOfCardsInDeck; ++j) {
                String currentCard = bf.readLine();
                if (!ownedCards.contains(currentCard) && desiredCards.contains(currentCard)) {
                    decks.get(i).add(currentCard);
                    if(!map.containsKey(currentCard)) {
                        map.putIfAbsent(currentCard, value);
                        ++value;
                    }
                }
            }
        }
        maxValue = value - 1; // n in output
        bf.close();
    }

    @Override
    public void formulateOracleQuestion() throws IOException {
        decks.removeIf(o -> o.size() == 0);
        decksNo = decks.size();

        dataSize.add(maxValue);
        dataSize.add(decksNo);
        for (int i = 0; i < decksNo; ++i) {
            codedValues.add(new ArrayList<>());
            codedValues.get(i).add(decks.get(i).size());
            for (String card : decks.get(i)) {
                codedValues.get(i).add(map.get(card));
            }
        }

    }

    @Override
    public void decipherOracleAnswer() throws IOException {
        FileReader fileReader = new FileReader("sat.sol");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String gogu = stringTokenizer.nextToken();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        gogu = stringTokenizer.nextToken();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int max = Integer.parseInt(gogu);
        for (int i = 0; i < max; ++i) {
            gogu = stringTokenizer.nextToken();
            int nrGogu = Integer.parseInt(gogu);
            if (nrGogu > 0) {
                ref.add((nrGogu % decksNo) != 0 ? nrGogu % decksNo : ((nrGogu < maxValue) ? nrGogu :
                        decksNo));
            }
        }
        Collections.sort(ref);

        fileReader.close();
        bufferedReader.close();
    }

    @Override
    public void writeAnswer() throws IOException {
        System.out.println(k);
        for(int i = 0; i < ref.size(); ++i) {
            System.out.print(ref.get(i) + " ");
        }
        System.out.println();
    }
}
