package pl.memexurer.supercommands;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Minecart;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import pl.memexurer.supercommands.commands.DrinksCommand;
import pl.memexurer.supercommands.commands.MineRpCommand;
import pl.memexurer.supercommands.commands.ParkingCommand;
import pl.memexurer.supercommands.commands.WsiadzCommand;
import pl.memexurer.supercommands.listener.InteractListener;
import pl.memexurer.supercommands.listener.InventoryListener;
import pl.memexurer.supercommands.managers.DrinkManager;
import pl.memexurer.supercommands.managers.ShopkeeperManager;

public class SuperCommands extends JavaPlugin {
    private static WorldGuardPlugin worldguard;
    private static Economy econ;

    public void onEnable(){
        saveDefaultConfig();
        initWg();
        DrinkManager.load(this.getConfig());
        ShopkeeperManager.load(this.getConfig());
        registerCommands();
        registerListeners();
    }

    private void initWg() {
        worldguard = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
    }

    public static WorldGuardPlugin getWorldguard() {
        return worldguard;
    }

    public static Economy getEconomy() { return econ; }
    private void registerCommands() {
        getCommand("parking").setExecutor(new ParkingCommand());
        getCommand("wsiadz").setExecutor(new WsiadzCommand());
        getCommand("minerp").setExecutor(new MineRpCommand());
        getCommand("drinks").setExecutor(new DrinksCommand());
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
    }
}
