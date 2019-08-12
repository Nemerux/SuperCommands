package pl.memexurer.supercommands.obj;

import org.bukkit.Material;

import java.util.ArrayList;

public class ShopkeeperItem {
    private String id;
    private Material material;
    private String itemName;
    private ArrayList<String> itemLore;
    private String command;
    private int price;

    public ShopkeeperItem(String id, Material material, String itemName, ArrayList<String> itemLore, String command, int price) {
        this.id = id;
        this.material = material;
        this.itemName = itemName;
        this.itemLore = itemLore;
        this.command = command;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public Material getMaterial() {
        return material;
    }

    public String getItemName() {
        return itemName;
    }

    public ArrayList<String> getItemLore() {
        return itemLore;
    }

    public String getCommand() {
        return command;
    }

    public int getPrice() {
        return price;
    }
}
