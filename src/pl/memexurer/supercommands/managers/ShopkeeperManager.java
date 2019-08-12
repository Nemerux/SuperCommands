package pl.memexurer.supercommands.managers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import pl.memexurer.supercommands.obj.Shopkeeper;
import pl.memexurer.supercommands.obj.ShopkeeperItem;
import pl.memexurer.supercommands.util.ColorUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ShopkeeperManager {
    private static HashMap<String, Shopkeeper> shopMap = new HashMap<>();

    public static void load(Configuration config) {
        if(config.getConfigurationSection("shopkeepers") == null) return;
        for(String shopName: config.getConfigurationSection("shopkeepers").getKeys(false)) {
            String npcName = config.getString("shopkeepers." + shopName + ".npc_name");
            boolean useFakeMoney = config.getBoolean("shopkeepers." + shopName + ".use_real_money");
            String inventoryTitle = config.getString("shopkeepers." + shopName + ".inventory_title");
            ArrayList<ShopkeeperItem> items = new ArrayList<>();
            for(String itemId: config.getConfigurationSection("shopkeepers." + shopName + ".npc_items").getKeys(false)) {
                ConfigurationSection section =  config.getConfigurationSection("shopkeepers." + shopName + ".npc_items").getConfigurationSection(itemId);
                Material itemType = Material.getMaterial(section.getString("type"));
                String itemName = ColorUtil.color(section.getString("name"));
                ArrayList<String> itemLore = ColorUtil.colorList(section.getStringList("lore"));
                String command = section.getString("command");
                int price = section.getInt("price");
                items.add(new ShopkeeperItem(itemId, itemType, itemName, itemLore, command, price));
            }
            shopMap.put(npcName, new Shopkeeper(npcName, items, useFakeMoney, inventoryTitle));
        }
    }

    public static Shopkeeper findByInventoryTitle(String invTitle) {
        if(invTitle == null) return null;
        for(Shopkeeper sh: shopMap.values()) {
            if(ColorUtil.color(sh.getInventoryTitle()).equals(invTitle)) {
                return sh;
            }
        }
        return null;
    }

    public static Shopkeeper getByName(String name) {
        return shopMap.get(name);
    }


}
