package commands;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class Talk {

    public static void talk (MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {
        String[] serverID = {
                "181899302023593984",
                "184887073688387584"
        };
        if (event.getMessage().toString().startsWith("/t0 ")) {
            String talkMessage = event.getMessage().toString().substring(4);
            event.getClient().getChannelByID(serverID[0]).sendMessage(talkMessage);
        }
        if (event.getMessage().toString().startsWith("/t1 ")) {
            String talkMessage = event.getMessage().toString().substring(4);
            event.getClient().getChannelByID(serverID[1]).sendMessage(talkMessage);
        }
    }
}
