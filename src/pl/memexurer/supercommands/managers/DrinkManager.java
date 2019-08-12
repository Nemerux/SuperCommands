package pl.memexurer.supercommands.managers;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.MemorySection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionBrewer;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pl.memexurer.supercommands.obj.Drink;
import pl.memexurer.supercommands.util.ColorUtil;

import java.util.ArrayList;

public class DrinkManager {
    private static ArrayList<Drink>  drinks = new ArrayList<>();

    public static void load(Configuration config) {
        if(config.getConfigurationSection("drinks") == null) return;
        for(String drinkName: config.getConfigurationSection("drinks").getKeys(false)) {
            ConfigurationSection section = config.getConfigurationSection("drinks." + drinkName);
            String drinkItemName = ColorUtil.color(section.getString("name"));
            String colorHex = section.getString("colors");
            ArrayList<String> lore =  ColorUtil.colorList(section.getStringList("lore"));
            ArrayList<PotionEffect> effects= new ArrayList<>();
            for(String potionRaw: section.getStringList("effects")) {
                PotionEffectType type = PotionEffectType.getByName(potionRaw.split(" ")[0]);
                int strength = Integer.parseInt(potionRaw.split(" ")[1]);
                int duration = Integer.parseInt(potionRaw.split(" ")[2]);
                effects.add(new PotionEffect(type, duration * 20, strength - 1));
            }
            int price = section.getInt("price");
            drinks.add(new Drink(drinkName, drinkItemName, lore, effects, price, colorHex));
        }
    }


    public static Drink findPotion(String name) {
        for (Drink p : drinks) if (p.getName().equalsIgnoreCase(name)) return p;
        return null;
    }

    public static boolean givePlayer(Player p, String drinkName) {
        Drink drink = findPotion(drinkName);
        if(drink == null) return false;
        ItemStack item = new ItemStack( Material.POTION, 1);
        PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
        drink.getPotionEffect().forEach(potionEffect -> potionMeta.addCustomEffect(potionEffect, false));
        String colorStr = drink.getColorHex();
        int  r=  Integer.valueOf( colorStr.substring( 1, 3 ), 16 );
        int  g=  Integer.valueOf( colorStr.substring( 3, 5 ), 16 );
        int  b=  Integer.valueOf( colorStr.substring( 5, 7 ), 16 );
        potionMeta.setColor(Color.fromRGB(r,g,b));
        potionMeta.setDisplayName(drink.getItemName());
        potionMeta.setLore(drink.getItemLore());
        item.setItemMeta(potionMeta);
        p.getInventory().addItem(item);
        return true;
    }

}
