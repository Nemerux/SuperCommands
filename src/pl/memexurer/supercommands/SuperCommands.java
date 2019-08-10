package pl.memexurer.supercommands;

import org.bukkit.entity.Minecart;
import org.bukkit.plugin.java.JavaPlugin;
import pl.memexurer.supercommands.commands.MineRpCommand;

public class SuperCommands extends JavaPlugin {
    private void registerCommands() {
        getCommand("minerp").setExecutor(new MineRpCommand());
    }
}
