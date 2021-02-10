package me.dunctel123.jdatuts.commands;

import me.dunctel123.jdatuts.CommandManager;
import me.dunctel123.jdatuts.Config;
import me.dunctel123.jdatuts.command.CommandContext;
import me.dunctel123.jdatuts.command.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
import java.util.List;

public class HelpCommand implements ICommand {

    public HelpCommand(CommandManager manager) {
        this.manager = manager;
    }

    private final CommandManager manager;
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();
        if (args.isEmpty()) {
            StringBuilder builder = new StringBuilder();

            builder.append("List of commands\n");
            EmbedBuilder embed = new EmbedBuilder()
                    .setColor(Color.blue)
                    .setFooter("type !!help [command] for more info");

            manager.getCommands().stream().map(ICommand::getName).forEach(
                    (it) -> builder.append('`').append(Config.get("prefix")).append(it).append("`\n")
            );
            embed.setDescription(builder.toString());
            channel.sendMessage(embed.build()).queue();
            return;
        }
        EmbedBuilder embed = new EmbedBuilder()
                .setFooter("It is very easy boi!!")
                .setColor(Color.blue)
                .setTitle("HelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelpHelp");
        String search = args.get(0);
        ICommand command = manager.getCommand(search);

        if (command == null) {
            channel.sendMessage("Nothing found for " + search).queue();
            return;
        }
        embed.setDescription(command.getHelp());
        channel.sendMessage(embed.build()).queue();
        return;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getHelp() {
        return "Shows the list with commands in the bot\n" +
                "Usage: `!!help [command]`";
    }

    @Override
    public List<String> getAliases() {
        return List.of("commands", "cmds", "commandlist");
    }
}
