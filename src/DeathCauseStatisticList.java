import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DeathCauseStatisticList {
    ArrayList<DeathCauseStatistic> data;

    public DeathCauseStatisticList(ArrayList<DeathCauseStatistic> data) {
        this.data = data;
    }

    public DeathCauseStatisticList() {
    }

    public void add(DeathCauseStatistic a) throws NullPointerException{
        try {
            data.add(a);
        } catch (NullPointerException npe){
            npe.getMessage();
        }
    }

    public void repopulate(Path path) throws IOException, NoSuchElementException {
        this.data.clear();
        ArrayList<DeathCauseStatistic> firstList = new ArrayList<>();
        Scanner skan = new Scanner(path);
        skan.nextLine();
        skan.nextLine();
        String disease = null;
        while(skan.hasNextLine()){
            String line = skan.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            disease = tokenizer.nextToken();
            disease = disease.trim();
            int a;
            int[] noDeaths = new int[20];
            for (int i=0; i<20; i++) {
                String token = tokenizer.nextToken();
                if (token.equals("-")) {
                    a = 0;
                } else {
                    a = Integer.parseInt(token);
                }
                noDeaths[i] = a;
            }
            firstList.add(new DeathCauseStatistic(disease, noDeaths));
        }
        this.data = firstList;
        }


    @Override
    public String toString() {
        return "DeathCauseStatisticList{" +
                "data=" + data +
                '}';
    }


    public ArrayList<DeathCauseStatistic> mostDeadlyDiseases(int age, int n){
        int length = this.data.size();
        if (n < length){
            throw new IndexOutOfBoundsException();
        }



    }

}
