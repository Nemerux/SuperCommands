package pl.memexurer.supercommands.util;

import com.sk89q.worldedit.Vector;
import com.sk89q.worldguard.bukkit.BukkitUtil;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.Location;
import pl.memexurer.supercommands.SuperCommands;

public class RegionUtil {
    public static boolean inRegion(Location loc, String regionID)
    {
        WorldGuardPlugin guard = SuperCommands.getWorldguard();
        Vector v = BukkitUtil.toVector(loc);
        RegionManager manager = guard.getRegionManager(loc.getWorld());
        ApplicableRegionSet set = manager.getApplicableRegions(v);
        for(ProtectedRegion region: set) {
            if(region.getId().equalsIgnoreCase(regionID)) {
                return true;
            }
        }
        return false;

    }
}
