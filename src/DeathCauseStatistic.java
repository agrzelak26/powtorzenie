import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.math.MathContext;
public class DeathCauseStatistic {

    public class AgeBracketDeaths{
        public final int young;
        public final int old;
        public final int deathCount;
        public AgeBracketDeaths(int young, int old, int deathCount) {
            this.young = young;
            this.old = old;
            this.deathCount = deathCount;
        }

        @Override
        public String toString() {
            return "AgeBracketDeaths{" +
                    "young=" + young +
                    ", old=" + old +
                    ", deathCount=" + deathCount +
                    '}';
        }
    }
    public AgeBracketDeaths create(int age) throws ImpossibleAgeException{
        if (age < 0) {
            throw new ImpossibleAgeException();
        }
            int index = Math.floorDiv(age, 5);
            int young = index * 5;
            int old = young + 4;
            int deathCount = numbOfDeaths[index];
            return new AgeBracketDeaths(young, old, deathCount);
    }


    public DeathCauseStatistic(String diseaseCode, int[] numbOfDeaths) {
        this.diseaseCode = diseaseCode;
        this.numbOfDeaths = numbOfDeaths;
    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    private String diseaseCode;
    private int[] numbOfDeaths;

    public static DeathCauseStatistic fromCsvLine(String line){

        StringTokenizer tokenizer = new StringTokenizer(line, ",");
        String disease = tokenizer.nextToken();
        disease = disease.trim();
        int[] noDeaths = new int[20];
        for (int i=0; i<20; i++){
            String token = tokenizer.nextToken();
            int a;
            if(token.equals("-")){
                a = 0;
            } else {
                a = Integer.parseInt(token);
            }
            noDeaths[i] = a;
        }
        return new DeathCauseStatistic(disease, noDeaths);
    }

    @Override
    public String toString() {
        return "DeathCauseStatistic{" +
                "diseaseCode='" + diseaseCode + '\'' +
                ", numbOfDeaths=" + Arrays.toString(numbOfDeaths) +
                '}';
    }
}

