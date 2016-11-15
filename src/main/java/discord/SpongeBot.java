package discord;

import commands.*;
import org.json.JSONObject;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.io.FileNotFoundException;

public class SpongeBot {

    public static SpongeBot INSTANCE;
    public IDiscordClient client;

    public static void main(String[] args) {
        try {
            JSONParser.parse("C:/Users/Richard/Documents/SpongeBot/config.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JSONObject obj = new JSONObject(JSONParser.jsonData);
        INSTANCE = login(obj.getString("token"));
    }

    public SpongeBot(IDiscordClient client) {
        this.client = client;
        EventDispatcher dispatcher = client.getDispatcher();
        dispatcher.registerListener(new EventHandler());
    }

    public static SpongeBot login(String token) {
        SpongeBot bot = null;

        ClientBuilder builder = new ClientBuilder();
        builder.withToken(token);
        try {
            IDiscordClient client = builder.login();
            bot = new SpongeBot(client);
        } catch (DiscordException e) {
            System.err.println("Error occurred while logging in!");
            e.printStackTrace();
        }

        return bot;
    }

    public class EventHandler {

        @EventSubscriber
        public void onReadyEvent(ReadyEvent event) {
            System.out.println("The bot is now ready");
        }

        @EventSubscriber
        public void onMessageReceivedEvent(MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {

            System.out.println(event.getMessage().getAuthor().getName() + ": " + event.getMessage());

            Announcer.announcer(event);
            BotJoin.botJoin(event);
            Help.help(event);
            MagicConch.magicConch(event);
            NameChanger.nameChanger(event);
            PingPong.pingPong(event);
            RPS.rps(event);
            Talk.talk(event);
            Test.test(event);
            TopicChanger.topicChanger(event);
            VoteKick.voteKick(event);
        }
    }
}