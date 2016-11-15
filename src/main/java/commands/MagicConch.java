package commands;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class MagicConch {

    public static void magicConch (MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {
        if (event.getMessage().toString().startsWith(">8ball ") && event.getMessage().toString().substring(7) != " ") {
            if ((event.getMessage().toString().substring(7).length() > 5) || event.getMessage().toString().contains("?")) {
                String[] responses = {"It is certain", "It is decidedly so", "Without a doubt", "Yes, definitely",
                        "You may rely on it", "As I see it, yes", "Most likely", "Outlook good", "Yes", "Signs point to yes", "Reply hazy try again",
                        "Ask again later", "Better not tell you now", "Cannot predict now", "Concentrate and ask again",
                        "Don't count on it", "My reply is no", "My sources say no", "Outlook not so good", "Very doubtful"};

                // Selected Responses
                if (event.getMessage().toString().toLowerCase().contains("kenny") && (event.getMessage().toString().toLowerCase().contains("gay"))) {
                    int numRandom = (int) (Math.random() * 9);
                    event.getMessage().getChannel().sendMessage(event.getMessage().getAuthor().mention() + " " + responses[numRandom]);
                } else if (event.getMessage().toString().toLowerCase().contains("richard") && (event.getMessage().toString().toLowerCase().contains("gay"))) {
                    int numRandom = (int) ((Math.random() * 4) + 15);
                    event.getMessage().getChannel().sendMessage(event.getMessage().getAuthor().mention() + " " + responses[numRandom]);
                } else {
                    int numRandom = (int) (Math.random() * 19);
                    event.getMessage().getChannel().sendMessage(event.getMessage().getAuthor().mention() + " " + responses[numRandom]);
                }
            } else {
                event.getMessage().getChannel().sendMessage(event.getMessage().getAuthor().mention() + " Please ask a question");
            }
        }
    }
}
