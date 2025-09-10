package Commands;

import Persistence.DataStorage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CheckLives implements CommandExecutor {

    DataStorage persistentData;

    public CheckLives(DataStorage data) {
        persistentData = data;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if(!(sender instanceof Player)) {
            Bukkit.getLogger().info("Command Sender is not a Player");
            return true;
        }

        sender.sendMessage("You have " + persistentData.getLives(((Player) sender).getPlayer()) + " lives left.");

        return true;
    }
}
