import java.io.IOException;

public class Rise {
    public static void main(String[] args) throws IOException, InterruptedException {
        RiseStuff task2 = new RiseStuff();
        task2.readProblemData();
        task2.formulateOracleQuestion();
        task2.solve();
        task2.decipherOracleAnswer();
        task2.writeAnswer();
    }
}
