package pl.memexurer.supercommands.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import pl.memexurer.supercommands.SuperCommands;
import xyz.kaspek.jobs.utils.BrudnaUtil;

public class EconomyUtils {
    public static boolean takeMoney(Player player, int money, boolean isReal) {
        if(isReal) {
            if(SuperCommands.getEconomy().getBalance(player) > money) {
                SuperCommands.getEconomy().withdrawPlayer(player, money);
                return true;
            } else {
                player.sendMessage(ChatColor.RED + "Nie posiadasz wystarczajacej kwoty na swoim koncie do zakupienia tego przedmiotu!");
                return false;
            }
        } else {
            if(BrudnaUtil.getBrudna(player.getName()) > money) {
                BrudnaUtil.removeBrudna(player.getName(), money);
                return true;
            } else {
                player.sendMessage(ChatColor.RED + "Nie posiadasz wystarczajacej kwoty na swoim koncie do zakupienia tego przedmiotu!");
                return false;
            }
        }
    }
}
