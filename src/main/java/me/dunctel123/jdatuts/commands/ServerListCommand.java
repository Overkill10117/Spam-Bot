package me.dunctel123.jdatuts.commands;

import me.dunctel123.jdatuts.command.CommandContext;
import me.dunctel123.jdatuts.command.ICommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;

import java.util.List;

public class ServerListCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        JDA jda = ctx.getJDA();
        List<Guild> list = jda.getGuilds();
        int i = 0;

        while (i < (list.size())) {
            ctx.getChannel().sendMessage("This bot is in " + list.get(i)).queue();
            i++;
        }
    }

    @Override
    public String getName() {
        return "serverlist";
    }

    @Override
    public String getHelp() {
        return "Usage: `/serverlist`\n" +
                "Displays the name of servers the bot is in.";
    }
}
