package Handlers;

import Persistence.DataStorage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.deltanoise.mediumcore.Mediumcore;

import java.time.Duration;

public class DeathHandling implements Listener {

    int banDuration = 1;
    DataStorage persistentData;

    public DeathHandling(Mediumcore plugin, DataStorage data) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        banDuration = plugin.getConfig().getInt("banDuration.value");
        persistentData = data;

    }

    @EventHandler
    public void OnPlayerDeath(EntityDeathEvent deathEvent) {

        if(deathEvent.getEntityType() == EntityType.PLAYER) {

            Player player = (Player) deathEvent.getEntity();

            if(persistentData.getLives(player) <= 1) {

                Bukkit.broadcastMessage(ChatColor.RED + "The player " +  player.getName() + " has been banned due to losing all lives");
                persistentData.resetLives(player);
                player.ban("Lost all lives", Duration.ofHours(banDuration), "World", true);

            } else {

                persistentData.setLives(player, persistentData.getLives(player) - 1);

                if(persistentData.getLives(player) == 1) {
                    Bukkit.broadcastMessage(player.getName() + " has " + persistentData.getLives(player) + " life left");
                }
                else {
                    Bukkit.broadcastMessage(player.getName() + " has " + persistentData.getLives(player) + " lives left");
                }
            }
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();


        if(persistentData.getLives(player) == 1) {
            Bukkit.broadcastMessage(ChatColor.GREEN + "You have " + persistentData.getLives(player) + " life left");
        }
        else {
            Bukkit.broadcastMessage(ChatColor.GREEN + "You have " + persistentData.getLives(player) + " lives left");
        }

    }
}
