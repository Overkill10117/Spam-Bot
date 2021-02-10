package me.dunctel123.jdatuts.commands;

import me.dunctel123.jdatuts.command.CommandContext;
import me.dunctel123.jdatuts.command.ICommand;

public class SpamCommand2 implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        int x = 0;

        while (x<200) {
            ctx.getChannel().sendMessage("spam").queue();
            x++;
        }
    }

    @Override
    public String getName() {
        return "spam1";
    }

    @Override
    public String getHelp() {
        return "spam";
    }
}

