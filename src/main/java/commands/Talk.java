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
        if (event.getMessage().getAuthor().getID().equals("164909448043823104") && event.getMessage().toString().length() > 4 && event.getMessage().toString().startsWith("/t")) {
            String talkMessage = event.getMessage().toString().substring(4);
            event.getClient().getChannelByID(serverID[Integer.parseInt(String.valueOf(event.getMessage().toString().charAt(2)))]).sendMessage(talkMessage);
        }
    }
}
