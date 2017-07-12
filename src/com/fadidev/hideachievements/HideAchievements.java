package com.fadidev.hideachievements;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class HideAchievements extends JavaPlugin implements Listener {

    @Override()
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    private void hideAdvancementsFor(World world) {
        world.setGameRuleValue("announceAdvancements", "false");
        getLogger().info("Achievements are now hidden for world '" + world.getName() + "'.");
    }

    /* Hide advancements for new worlds */
    @EventHandler(priority = EventPriority.MONITOR)
    public void onWorldLoad(WorldLoadEvent event) {
        hideAdvancementsFor(event.getWorld());
    }
}
