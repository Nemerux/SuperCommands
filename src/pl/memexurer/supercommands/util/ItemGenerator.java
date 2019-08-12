package pl.memexurer.supercommands.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemGenerator {
        public static ItemStack generate(String name, String description, int count, short meta, Material mater) {
        ItemStack i = new ItemStack(mater,count,meta);
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(ColorUtil.color(name));
        im.setLore(new ArrayList<>(Arrays.asList(ColorUtil.color(description).split("\\|"))));
        i.setItemMeta(im);
        return i;
    }

    public static ItemStack generate(String name, ArrayList<String> description, int count, short meta, Material mater) {
        ItemStack i = new ItemStack(mater,count,meta);
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(ColorUtil.color(name));
        im.setLore(ColorUtil.colorList(description));
        i.setItemMeta(im);
        return i;
    }

        public static ItemStack generateEnchant(String name, String description, int count, short meta, Material mater) {
            ItemStack i = new ItemStack(mater,count,meta);
            ItemMeta im = i.getItemMeta();
            im.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
            im.setDisplayName(ColorUtil.color(name));
            im.setLore(new ArrayList<>(Arrays.asList(ColorUtil.color(description).split("\\|"))));
            i.setItemMeta(im);
            return i;
        }
    /*
    public static Inventory fullEmpty(Inventory inv) {
        ItemStack emptyGlass = generateItemAdv("&f", "&f", Material.STAINED_GLASS_PANE, (short) 15, 1);
        for(int i = 0; i < inv.getSize(); i++) {
            if(inv.getItem(i) == null) {
                inv.setItem(i, emptyGlass);
            }
        }
        return inv;
    }
    */
}
