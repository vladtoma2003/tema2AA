import java.io.IOException;

public class Redemption{
    public static void main(String[] args) throws IOException, InterruptedException {
        RiseStuff task3 = new RiseStuff();
        task3.readProblemData();
        task3.formulateOracleQuestion();
        task3.solve();
        task3.decipherOracleAnswer();
        task3.writeAnswer();
    }
}
