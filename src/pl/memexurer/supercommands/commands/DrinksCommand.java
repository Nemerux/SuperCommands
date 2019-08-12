package pl.memexurer.supercommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.memexurer.supercommands.managers.DrinkManager;

public class DrinksCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!commandSender.hasPermission("drinks.give")) {
            return true;
        }

        if(strings.length != 1) {
            commandSender.sendMessage(ChatColor.RED + "Poprawne uzycie: /drinks (nazwa drinka)");
            return true;
        }

        if(!DrinkManager.givePlayer((Player) commandSender, strings[0])) {
            commandSender.sendMessage(ChatColor.RED + "Podany drink nie istnieje!");
            return true;
        }
        commandSender.sendMessage(ChatColor.GREEN + "Otrzymales drinka " + strings[0] + "!");
        return true;
    }
}
