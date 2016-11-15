package commands;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class PingPong {

    public static void pingPong (MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {
        if (event.getMessage().toString().equals("/o/")) {
            event.getMessage().getChannel().sendMessage("\\o\\");
        }
        if (event.getMessage().toString().equals("\\o\\")) {
            event.getMessage().getChannel().sendMessage("/o/");
        }
    }
}
