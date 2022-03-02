import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StarWarsAPItest {

    API api = new API();
    GetRequestRepository repository = new GetRequestRepository(api);

    @Test
    //testing the films query
    //this tests the getAll function of the films category.
    public void countAllMoviesTest(){

        JsonObject jsonObject = repository.getAll("films", null);
        String actual = jsonObject.get("count").toString();
        String expected = "6";

        //if this test fails they have probably update the API because the new movie is out.
        assertEquals(expected,actual);
    }


    @Test
    //testing the films query
    //this test proves the search function on films works and compares the given release date of the move "A New Hope"
    public void ANewHopeReleaseDateTest(){

        JsonObject jsonObject = repository.getAll("films", "hope");
        JsonArray results = jsonObject.getAsJsonArray("results");
        JsonObject film = results.get(0).getAsJsonObject();

        String expected = "1977-05-25";
        String actual = film.get("release_date").toString().replace("\"", "");

        assertEquals(expected,actual);
    }

    @Test
    //testing the planets query
    //this test proves the search function on planets works and compares the given population of the planet Naboo.
    public void NabooPopulationTest(){

        JsonObject jsonObject = repository.getAll("planets", "naboo");
        JsonArray results = jsonObject.getAsJsonArray("results");
        JsonObject planet = results.get(0).getAsJsonObject();

        String expected = "4500000000";
        String actual = planet.get("population").toString().replace("\"", "");

        assertEquals(expected,actual);
    }

    @Test
    //testing the starships query
    //this test proves the search function on starships works and compares the given model of the Death Star.
    public void DeathStarModelTest(){

        JsonObject jsonObject = repository.getAll("starships", "death");
        JsonArray results = jsonObject.getAsJsonArray("results");
        JsonObject starship = results.get(0).getAsJsonObject();

        String expected = "DS-1 Orbital Battle Station";
        String actual = starship.get("model").toString().replace("\"", "");

        assertEquals(expected,actual);
    }

    @Test
    //testing the single getrequest function
    //this test proves that the first guy in the database under people is Luke Skywalker.
    public void GetSingleEntity(){

        JsonObject person = repository.innerRequest("https://swapi.dev/api/people/1/");

        String expected = "Luke Skywalker";
        String actual = person.get("name").toString().replace("\"", "");

        assertEquals(expected,actual);
    }
}
