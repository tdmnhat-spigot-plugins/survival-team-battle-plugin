package dev.tdmnhat.plugin.command;

import dev.tdmnhat.plugin.SurvivalTeamBattle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCommand implements CommandExecutor {

    private SurvivalTeamBattle plugin;

    public AdminCommand() {
        plugin = (SurvivalTeamBattle) Bukkit.getPluginManager().getPlugin("SurvivalTeamBattle");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player player) {
            if(args.length > 1 && args[0].equalsIgnoreCase("admin")) {
                switch(args[1]) {
                    case "setspawn": {
                        Location location = player.getLocation();

                        return true;
                    }
                    case "create": {

                    }
                    default: {
                        player.sendMessage(ChatColor.RED + "Invalid command");
                    }
                }
            } else {
                player.sendMessage(ChatColor.RED + "[SurvivalTeamBattle] Invalid command");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "[SurvivalTeamBattle] This command is only executed by player");
        }
        return false;
    }
}
