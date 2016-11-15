package commands;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;
import java.util.ArrayList;
import java.util.List;

public class Announcer {

    public static void announcer(MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {
        if (event.getMessage().getAuthor().getID().equals("164909448043823104") && event.getMessage().toString().startsWith(".announce ")) {
            String message = event.getMessage().toString().substring(10);

            //Channel Parser
            List<String> channelList = new ArrayList<>();
            String channelString = event.getClient().getChannels().toString();

            System.out.println(channelString);

            String channelTemp = "", messageTemp = "", mentionIDTemp = "";

            //Gets channel ID's
            for (int i = 0; i < channelString.length(); i++) {
                if (Character.isDigit(channelString.charAt(i))) {
                    channelTemp += channelString.charAt(i);
                }
                if (channelString.charAt(i) == '>') {
                    channelList.add(channelTemp);
                    channelTemp = "";
                }
            }

            //Message Sending loop
            for (int i = 0; i < channelList.size(); i++) {
                event.getClient().getChannelByID(channelList.get(i)).sendMessage(message);
            }
        }
    }
}
