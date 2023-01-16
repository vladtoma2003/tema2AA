import java.io.*;

public class Trial {
    public static void main(String[] args) throws IOException, InterruptedException {
        OracleStuff task1 = new OracleStuff();
        task1.readProblemData();
        task1.formulateOracleQuestion();
        task1.askOracle();
        task1.decipherOracleAnswer();
        task1.writeAnswer();
    }
}
