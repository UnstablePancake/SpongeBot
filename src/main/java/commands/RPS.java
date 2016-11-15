package commands;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class RPS {

    public static void rps (MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {
        String[] symbolsRPS = {"rock", "paper", "scissors"};

        if (event.getMessage().toString().startsWith(">rps ")) {
            String choiceUser = event.getMessage().toString().toLowerCase().substring(5);
            String choiceBot = symbolsRPS[(int) (Math.random() * 3)];

            if (choiceUser.equals("rock") && choiceBot.equals("rock")) {
                event.getMessage().getChannel().sendMessage(event.getMessage().getAuthor().mention() + " :rocket: - :rocket: Tie");
            }
            if (choiceUser.equals("rock") && choiceBot.equals("paper")) {
                event.getMessage().getChannel().sendMessage(event.getMessage().getAuthor().mention() + " :rocket: - :paperclip: You lose");
            }
            if (choiceUser.equals("rock") && choiceBot.equals("scissors")) {
                event.getMessage().getChannel().sendMessage(event.getMessage().getAuthor().mention() + " :rocket: - :scissors: You win");
            }
            if (choiceUser.equals("paper") && choiceBot.equals("rock")) {
                event.getMessage().getChannel().sendMessage(event.getMessage().getAuthor().mention() + " :paperclip: - :rocket: You win");
            }
            if (choiceUser.equals("paper") && choiceBot.equals("paper")) {
                event.getMessage().getChannel().sendMessage(event.getMessage().getAuthor().mention() + " :paperclip: - :paperclip: Tie");
            }
            if (choiceUser.equals("paper") && choiceBot.equals("scissors")) {
                event.getMessage().getChannel().sendMessage(event.getMessage().getAuthor().mention() + " :paperclip: - :scissors: You lose");
            }
            if (choiceUser.equals("scissors") && choiceBot.equals("rock")) {
                event.getMessage().getChannel().sendMessage(event.getMessage().getAuthor().mention() + " :scissors: - :rocket: You lose");
            }
            if (choiceUser.equals("scissors") && choiceBot.equals("paper")) {
                event.getMessage().getChannel().sendMessage(event.getMessage().getAuthor().mention() + " :scissors: - :paperclip: You win");
            }
            if (choiceUser.equals("scissors") && choiceBot.equals("scissors")) {
                event.getMessage().getChannel().sendMessage(event.getMessage().getAuthor().mention() + " :scissors: - :scissors: Tie");
            }
        }
    }
}
