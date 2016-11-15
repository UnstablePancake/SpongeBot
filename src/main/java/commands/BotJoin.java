package commands;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IVoiceChannel;
import sx.blah.discord.util.MissingPermissionsException;

public class BotJoin {

    public static void botJoin (MessageReceivedEvent event) throws MissingPermissionsException {
        if (event.getMessage().toString().startsWith("!join")) {
            IVoiceChannel voiceChannel = event.getMessage().getAuthor().getConnectedVoiceChannels().get(0);
            voiceChannel.join();

            System.out.println("*Joined " + voiceChannel);
        }

        if (event.getMessage().toString().startsWith("!leave")) {
            IVoiceChannel voiceChannel = event.getClient().getUserByID("239839092836139009").getConnectedVoiceChannels().get(0);
            voiceChannel.leave();
        }
    }
}