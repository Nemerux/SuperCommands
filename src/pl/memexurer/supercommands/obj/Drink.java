package pl.memexurer.supercommands.obj;

import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;

public class Drink {
    private String name;
    private String itemName;
    private ArrayList<String> itemLore;
    private ArrayList<PotionEffect> potionEffect;
    private int price;
    private String colorHex;

    public Drink(String name, String itemName, ArrayList<String> itemLore, ArrayList<PotionEffect> potionEffect, int price, String colorHex) {
        this.name = name;
        this.itemName = itemName;
        this.itemLore = itemLore;
        this.potionEffect = potionEffect;
        this.price = price;
        this.colorHex = colorHex;
    }

    public String getName() {
        return name;
    }

    public String getColorHex() {
        return colorHex;
    }

    public String getItemName() {
        return itemName;
    }

    public ArrayList<String> getItemLore() {
        return itemLore;
    }

    public ArrayList<PotionEffect> getPotionEffect() {
        return potionEffect;
    }

    public int getPrice() {
        return price;
    }
}
