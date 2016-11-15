package commands;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class NameChanger {

    public static void nameChanger(MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {
        if ((event.getMessage().getAuthor().getID().equals("164909448043823104")) && event.getMessage().toString().startsWith(".setname ")) {
            String newName = event.getMessage().toString().substring(8);

            event.getClient().changeUsername(newName);
        }
    }
}
