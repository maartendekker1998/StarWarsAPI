import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArgumentSwitcher {

    private static final API apiCalls = new API();
    private GetRequestRepository repository = new GetRequestRepository(apiCalls);
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Printer printer = new Printer();

    public void switcher(String command, String searchquery) {

        JsonObject jsonObject;

        switch (command) {
            case "films":
                jsonObject = repository.getAll("films", searchquery);
                JsonArray filmresults = jsonObject.getAsJsonArray("results");
                printer.printDetailsFilms(filmresults);
                break;
            case "planets":
                jsonObject = repository.getAll("planets", searchquery);
                JsonArray planetresults = jsonObject.getAsJsonArray("results");
                printer.printDetailsPlanets(planetresults);
                break;
            case "starships":
                jsonObject = repository.getAll("starships", searchquery);
                JsonArray starshipresults = jsonObject.getAsJsonArray("results");
                printer.printDetailsStarships(starshipresults);
                break;
            default:
                System.out.println(command + " is not a available command");
                break;
        }
    }
}
