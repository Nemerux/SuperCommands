package pl.memexurer.supercommands.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pl.memexurer.supercommands.obj.Shopkeeper;
import pl.memexurer.supercommands.obj.ShopkeeperItem;
import pl.memexurer.supercommands.util.ColorUtil;
import pl.memexurer.supercommands.util.EconomyUtils;
import pl.memexurer.supercommands.util.ItemGenerator;

import java.util.stream.IntStream;

public class ShopGui {
    public static void openInventory(Player p, Shopkeeper shop) {
        Inventory inv = Bukkit.createInventory(null, 27, ColorUtil.color(shop.getInventoryTitle()));
        IntStream.range(10, 10 + shop.getItems().size()).forEach(i -> inv.setItem(i, generateItem(shop.getItems().get(6 - (16 - i)))));
p.openInventory(inv);
    }

    public static ItemStack generateItem(ShopkeeperItem item) {
       return ItemGenerator.generate(item.getItemName(), item.getItemLore(), 1, (short) 0, item.getMaterial());
    }

    public static void handleClick(Player p, Shopkeeper shop, int rawClick) {
        ShopkeeperItem item = shop.getItems().get(6 - (16 - rawClick));
        if(!EconomyUtils.takeMoney(p, item.getPrice(), shop.isUseRealMoney())) {
            return;
        }
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), item.getCommand().replace("%player%", p.getName()));
        p.sendMessage(ChatColor.GREEN + "Pomyslnie zakupiles item!");
    }
}
