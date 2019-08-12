package pl.memexurer.supercommands.obj;

import java.util.ArrayList;

public class Shopkeeper {
    private String shopName;
    private ArrayList<ShopkeeperItem> items;
    private boolean useRealMoney;
    private String inventoryTitle;

    public Shopkeeper(String shopName, ArrayList<ShopkeeperItem> items, boolean useRealMoney, String inventoryTitle) {
        this.shopName = shopName;
        this.items = items;
        this.useRealMoney = useRealMoney;
        this.inventoryTitle = inventoryTitle;
    }

    public String getInventoryTitle() {
        return inventoryTitle;
    }

    public String getShopName() {
        return shopName;
    }

    public ArrayList<ShopkeeperItem> getItems() {
        return items;
    }

    public boolean isUseRealMoney() {
        return useRealMoney;
    }
}
