package commands;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class Talk {

    public static void talk (MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {

        if (event.getMessage().toString().startsWith("/t")) {
            String talkMessage = event.getMessage().toString().substring(3);

            event.getClient().getChannelByID("181899302023593984").sendMessage(talkMessage);
        }
    }
}
