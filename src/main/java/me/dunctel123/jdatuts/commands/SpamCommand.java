package me.dunctel123.jdatuts.commands;

import me.dunctel123.jdatuts.command.CommandContext;
import me.dunctel123.jdatuts.command.ICommand;

import java.util.List;

public class SpamCommand implements ICommand {
  @Override
  public void handle(CommandContext ctx) {
    final List<String> args = ctx.getArgs();

    if (args.isEmpty()) {
      int x = 0;

      while (x<200) {
        ctx.getChannel().sendMessageFormat("@everyone" + "%s dont know how to spam!!!").queue();
        x++;
      }
      return;
    }

    final int amount = Integer.parseInt(args.get(0));

    if (amount < 1) {
      ctx.getChannel().sendMessage("Invalid amount imputed").queue();
      return;
    }


    if (amount > 999) {
      ctx.getChannel().sendMessage("Too much spam count imputed").queue();
      return;
    }
    int supercore = 7;

    int hardcore = 3;

    if (amount < 10) {
      hardcore = 1;
    } else if (amount < 100) {
      hardcore = 2;
    }

    String word = ctx.getMessage().getContentRaw().substring(hardcore + supercore);

    int goal = 5;
    int x = 1;
    String message = "";

    while (x <= amount) {
      message = message + "\n" + word;

      if (x == goal) {
        ctx.getChannel().sendMessage(message).queue();
        goal += 5;
        message = "";
      }
      x++;
    }

    if (!message.isEmpty()) {
      ctx.getChannel().sendMessage(message).queue();
    }
  }

  @Override
  public String getName() {
    return "spam";
  }

  @Override
  public String getHelp() {
    return "spam [num] [word]";
  }
}