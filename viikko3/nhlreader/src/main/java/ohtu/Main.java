package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        System.out.println("json-muotoinen data:");
        System.out.println(bodyText);

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);

        Arrays.stream(players).filter(player -> player.getNationality().equals("FIN")).sorted(Comparator.comparing(Player::getPoints, Comparator.reverseOrder()))
                .forEach(player -> {
                    System.out.printf("%-20s %s", player.getName(), player.getTeam() + "\t" + player.getGoals() + " + " + player.getAssists() + " = " + (player.getGoals() + player.getAssists()) + "\n");
                });
    }

}
