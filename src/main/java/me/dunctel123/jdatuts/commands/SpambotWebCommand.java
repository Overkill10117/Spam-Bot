package me.dunctel123.jdatuts.commands;

import me.dunctel123.jdatuts.command.CommandContext;
import me.dunctel123.jdatuts.command.ICommand;

public class SpambotWebCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        ctx.getChannel().sendMessage("https://sites.google.com/view/thespambottheofficialweb/home?authuser=0").queue();
    }

    @Override
    public String getName() {
        return "web";
    }

    @Override
    public String getHelp() {
        return "bot's official web";
    }
}
