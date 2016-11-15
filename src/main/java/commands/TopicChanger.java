package commands;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class TopicChanger {

    public static void topicChanger (MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {
        if (event.getMessage().toString().startsWith("!settopic ")) {
            String newTopic = event.getMessage().toString().substring(10);
            String id = event.getMessage().getChannel().getID();
            event.getClient().getChannelByID(id).changeTopic(newTopic);
        }

        if (event.getMessage().toString().startsWith("!resettopic")) {
            String id = event.getMessage().getChannel().getID();
            event.getClient().getChannelByID(id).changeTopic(null);
        }
    }
}
