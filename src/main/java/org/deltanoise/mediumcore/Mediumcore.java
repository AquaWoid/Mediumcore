package org.deltanoise.mediumcore;

import Commands.CheckLives;
import Commands.ResetLives;
import Handlers.DeathHandling;
import Persistence.DataStorage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mediumcore extends JavaPlugin {

    DataStorage persistentData;

    @Override
    public void onEnable() {

        Bukkit.getLogger().info(ChatColor.RED + "Mediumcore Loaded");

        saveDefaultConfig();
        persistentData = new DataStorage(this);
        new DeathHandling(this,persistentData);


        try {
            getCommand("resetlives").setExecutor((new ResetLives(persistentData)));
            getCommand("checklives").setExecutor(new CheckLives(persistentData));
        } catch (Exception e) {
            getLogger().info("Error:" + e);
        }


    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(ChatColor.GREEN + "Mediumcore Shut Down");
    }
}
