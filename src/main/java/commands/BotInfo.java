package commands;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.Status;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class BotInfo {

    public static void botInfoChanger (MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {
        if ((event.getMessage().getAuthor().getID().equals("164909448043823104")) && event.getMessage().toString().startsWith(".setname ")) {
            String newName = event.getMessage().toString().substring(8);
            event.getClient().changeUsername(newName);
        }
        if ((event.getMessage().getAuthor().getID().equals("164909448043823104")) && event.getMessage().toString().startsWith(".resetname")) {
            event.getClient().changeUsername("Sponge");
        }
        if ((event.getMessage().getAuthor().getID().equals("164909448043823104")) && event.getMessage().toString().startsWith(".setstatus ")) {
            String newTopic = event.getMessage().toString().substring(11);
            event.getClient().changeStatus(Status.game(newTopic));
        }
        if ((event.getMessage().getAuthor().getID().equals("164909448043823104")) && event.getMessage().toString().startsWith(".resetstatus")) {
            event.getClient().changeStatus(Status.game(null));
        }
    }
}