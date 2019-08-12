package pl.memexurer.supercommands.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.memexurer.supercommands.gui.ShopGui;
import pl.memexurer.supercommands.managers.ShopkeeperManager;
import pl.memexurer.supercommands.obj.Shopkeeper;

public class InventoryListener implements Listener {

    @EventHandler
public void onClick(InventoryClickEvent e) {
    if(e.getClickedInventory() == null) return;
    Shopkeeper shopkeeper = ShopkeeperManager.findByInventoryTitle(e.getClickedInventory().getTitle());
    if(shopkeeper == null) return;
    e.setCancelled(true);
    ShopGui.handleClick((Player) e.getWhoClicked(), shopkeeper, e.getRawSlot());
    }
}
