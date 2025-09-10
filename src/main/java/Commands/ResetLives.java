package Commands;

import Persistence.DataStorage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.deltanoise.mediumcore.Mediumcore;

import javax.xml.crypto.Data;

public class ResetLives implements CommandExecutor {


    DataStorage persistentData;
    Mediumcore plugin;

    public ResetLives(DataStorage data) {
        persistentData = data;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if((sender instanceof Player) && plugin.getConfig().getBoolean("commands.allowReset")) {

            sender.sendMessage("Players are not allowed to use this command");

            Bukkit.getLogger().info("Players are not allowed to use this command");
            return true;
        }


        if(Bukkit.getPlayer(args[0]) != null) {
            persistentData.resetLives(Bukkit.getPlayerExact(args[0]));
        } else {

            persistentData.resetLives((Player) sender);

        }

        return true;
    }
}
