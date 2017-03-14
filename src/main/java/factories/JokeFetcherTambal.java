package factories;

import entity.Joke;

import static com.jayway.restassured.RestAssured.given;

public class JokeFetcherTambal implements IJokeFetcher {

    @Override
    public Joke retrieveJoke() {
        try {
            String joke = given().get("http://tambal.azurewebsites.net/joke/random").path("joke");
            return new Joke(joke, "http://tambal.azurewebsites.net/joke/random");
        } catch (Exception e) {
            return null;
        }
    }
}
