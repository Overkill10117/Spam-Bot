package me.dunctel123.jdatuts.commands;

import me.duncte123.botcommons.messaging.EmbedUtils;
import me.dunctel123.jdatuts.command.CommandContext;
import me.dunctel123.jdatuts.command.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

public class InviteSpamBotsCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        final TextChannel channel = ctx.getChannel();
        final EmbedBuilder embed = EmbedUtils.defaultEmbed()
                .setFooter("spamspamspamspamspamspamspamspamspamspamspamspamspamspamspamspamspamspamspamspamspamspamspamspam")
                .setTitle("Invite the Spam Bots")
                .setDescription("spam bot-https://discord.com/api/oauth2/authorize?client_id=795555997337780224&permissions=8&scope=bot"+
                        " spam bot 2-https://discord.com/api/oauth2/authorize?client_id=783925909987131402&permissions=8&scope=bot"+
                        " Ultimate spam bot-https://discord.com/api/oauth2/authorize?client_id=796183759128100864&permissions=8&scope=bot");
        channel.sendMessage(embed.build()).queue();
    }

    @Override
    public String getName() {
        return "spambots";
    }

    @Override
    public String getHelp() {
        return "invite the spam bots";
    }
}
