package dev.tdmnhat.plugin.command;

import dev.tdmnhat.plugin.SurvivalTeamBattle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {

    private SurvivalTeamBattle plugin;

    public MainCommand() {
        plugin = (SurvivalTeamBattle) Bukkit.getPluginManager().getPlugin("SurvivalTeamBattle");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player player) {
            if(args.length > 0) {
                switch(args[0]) {
                    case "spawn": {

                    }
                    default: {
                        sender.sendMessage(ChatColor.RED + "[SurvivalGameBattle] Invalid command");
                    }
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED + "[SurvivalGameBattle] This command is only executed by player");
        }
        return false;
    }
}
