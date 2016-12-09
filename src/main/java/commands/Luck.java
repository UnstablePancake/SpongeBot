package commands;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class Luck {
    public static void testLuck (MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {
        if (event.getMessage().toString().startsWith(">luck ")) {
            String userGuess = event.getMessage().toString().substring(6);
            int botGuess = (int)(Math.random() * 10);

            if (Integer.parseInt(userGuess) >= 1 || Integer.parseInt(userGuess) <= 10)
                if (userGuess.equals(Integer.toString(botGuess))) {
                    event.getMessage().getChannel().sendMessage(event.getMessage().getAuthor().mention() + " You are lucky! The number was " + botGuess);
                }
                else {
                    event.getMessage().getChannel().sendMessage(event.getMessage().getAuthor().mention() + " You are not lucky! The number was " + botGuess);
                }
            else {
                event.getMessage().getChannel().sendMessage((event.getMessage().getAuthor().mention() + "Enter a number must be from 1-10"));
            }
        }
    }

    public static void coinFlip(MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {
        if (event.getMessage().toString().startsWith(">coinflip")){
            int random = (int)(Math.random() * 100);
            if (random < 50){
                event.getMessage().getChannel().sendMessage(event.getMessage().getAuthor().mention() + " Heads");
            }
            else {
                event.getMessage().getChannel().sendMessage(event.getMessage().getAuthor().mention() + " Tails");
            }
        }
    }
}
