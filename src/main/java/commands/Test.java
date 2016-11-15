package commands;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;

public class Test {

    public static void test (MessageReceivedEvent event) {
        if (event.getMessage().toString().startsWith(".test")) {

        }
    }
}