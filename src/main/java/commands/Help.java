package commands;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class Help {

    public static void help (MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {
        if (event.getMessage().toString().startsWith(">help")) {
            event.getMessage().getChannel().sendMessage(event.getMessage().getAuthor().mention() + "```>8ball, /o/, \\o\\```");
        }
    }
}
