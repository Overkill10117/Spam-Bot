package me.dunctel123.jdatuts;

import me.duncte123.botcommons.messaging.EmbedUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;

public class Bot {

    private Bot() throws LoginException {
        EmbedUtils.setEmbedBuilder(
                () -> new EmbedBuilder()
                        .setColor(0x0062ff)
                        .setFooter("lol")
        );

        JDABuilder.createDefault(
                Config.get("token")

        )
                .setDisabledCacheFlags(EnumSet.of(
                        CacheFlag.CLIENT_STATUS,
                        CacheFlag.ACTIVITY
                ))
                .setToken(Config.get("token"))
                .addEventListeners(new Listener())
                .setActivity(Activity.playing("Spam"))
                .build();
    }

    public static void main(String[] args) throws LoginException {
        new Bot();
    }
}
