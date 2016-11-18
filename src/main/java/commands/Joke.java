package commands;

import com.google.gson.Gson;
import commands.search.JokeAPI;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.io.IOException;

public class Joke {
    private static OkHttpClient client = new OkHttpClient();

    public static void jokeOut (MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {
        if (event.getMessage().toString().startsWith("~yomamma")) {
            for (String str : joke()) {
                event.getMessage().getChannel().sendMessage(str);
            }
        }
    }

    public static String getJSON(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String[] joke() {
        String json = null;
        try {
            json = getJSON("http://api.yomomma.info");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();

        JokeAPI jokeAPI = gson.fromJson(json, JokeAPI.class);

        return new String[] {
                jokeAPI.getJoke()
        };
    }
}
