package pl.memexurer.supercommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.memexurer.supercommands.util.RegionUtil;

public class ParkingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {
            return true;
        }

        Player p = (Player) commandSender;
        if(!RegionUtil.inRegion(p.getLocation(), "parking")) {
            p.sendMessage(ChatColor.RED + "Nie znajdujesz się na parkingu!");
            return true;
        }

        if(strings.length == 0) {
            p.chat("/srv garage " + p.getName());
            return true;
        }

        if(strings[0].equalsIgnoreCase("motor")) {
            p.chat("/srv garage MOTOR " + p.getName());
            return true;
        }

        p.chat("/srv garage " + p.getName());
        return true;
    }
}
