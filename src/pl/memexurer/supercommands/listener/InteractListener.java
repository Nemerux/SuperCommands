package pl.memexurer.supercommands.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import pl.memexurer.supercommands.gui.ShopGui;
import pl.memexurer.supercommands.managers.ShopkeeperManager;
import pl.memexurer.supercommands.obj.Shopkeeper;

public class InteractListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent e) {
        // if(e.getRightClicked().getType() != EntityType.PLAYER) return;
        Shopkeeper shop = ShopkeeperManager.getByName(e.getRightClicked().getName());
        if(shop == null) return;
        ShopGui.openInventory(e.getPlayer(), shop);
    }
}
