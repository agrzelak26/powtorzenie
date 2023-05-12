import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ImpossibleAgeException {
        Path path = Paths.get("C:\\Users\\ola\\IdeaProjects\\powtorzenie\\src\\zgony.csv");
        Scanner skan = new Scanner(path);
        skan.nextLine();
        skan.nextLine();
        skan.nextLine();
        String line = skan.nextLine();

        DeathCauseStatistic someStatstics = DeathCauseStatistic.fromCsvLine(line);
        System.out.println(someStatstics.toString());

        DeathCauseStatistic.AgeBracketDeaths informations = someStatstics.create(64);
        System.out.println(informations.toString());
        ArrayList<DeathCauseStatistic> list = new ArrayList<>();
        list.add(someStatstics);

        DeathCauseStatisticList st = new DeathCauseStatisticList(list);
        st.add(someStatstics);
        st.repopulate(path);
        System.out.println(st.toString());
    }
}