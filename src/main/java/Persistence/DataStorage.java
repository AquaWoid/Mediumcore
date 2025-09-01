package Persistence;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.deltanoise.mediumcore.Mediumcore;

public class DataStorage {

    NamespacedKey livesKey;
    int defaultLive;

    public DataStorage(Mediumcore plugin) {
        livesKey = new NamespacedKey(plugin, "lives");
        defaultLive = plugin.getConfig().getInt("lives.value");
    }

    public void setLives(Player player, int lives) {
        player.getPersistentDataContainer().set(livesKey, PersistentDataType.INTEGER, lives);
    }

    public int getLives(Player player) {
        return player.getPersistentDataContainer().getOrDefault(livesKey, PersistentDataType.INTEGER, defaultLive);
    }

    public void resetLives(Player player) {
        player.getPersistentDataContainer().set(livesKey, PersistentDataType.INTEGER, defaultLive);
    }
}