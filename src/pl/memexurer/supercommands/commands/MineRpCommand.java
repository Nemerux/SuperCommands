package pl.memexurer.supercommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MineRpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        /*
                if arg 1 is not set:
            execute player command "/minecord help"
            stop
        else if arg 1 is "polacz":
            execute player command "/minecord link"
            stop
        else if arg 1 is "mow":
            execute player command "/minecord toggle"
            stop
        execute player command "/minecord help"
        stop
         */

        if(!(commandSender instanceof Player)) return true;

        Player p = (Player) commandSender;
        if(strings.length == 0) {
            exec(p, "/minecord help");
        } else if(strings[0].equalsIgnoreCase("polacz")) {
            exec(p, "/minecord link");
        } else if(strings[0].equalsIgnoreCase("mow")) {
            exec(p, "/minecord toggle");
        } else {
            exec(p, "/minecord help");
        }
        return true;
    }

    private void exec(Player player, String command) {
        player.chat(command);
    }
}
