package commands;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class VoteKick {

    public static void voteKick(MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {

        int yes = 0, no = 0;

        if (event.getMessage().toString().startsWith(">votekick ")) {
            String kickUser = event.getMessage().toString().substring(10);

            String messageID = event.getMessage().getChannel().sendMessage("Would you like to kick " + kickUser + " \"F1\" to accept. \"F2\" to deny.\nYes: " + yes + ". No: " + no + ".").getID();
        }
    }
}