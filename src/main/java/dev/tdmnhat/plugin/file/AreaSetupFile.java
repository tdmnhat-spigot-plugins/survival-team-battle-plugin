package dev.tdmnhat.plugin.file;

import dev.tdmnhat.plugin.SurvivalTeamBattle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class AreaSetupFile {

    private static SurvivalTeamBattle plugin;
    private static File file;
    private static FileConfiguration configuration;

    public static void setup(String areaName) {
        try {
            plugin = (SurvivalTeamBattle) Bukkit.getPluginManager().getPlugin("SurvivalBattleTeam");
            // Create folder if not exist
            new File(plugin.getDataFolder() + "/area").mkdir();

            // Create file
            file = new File(plugin.getDataFolder() + "/area/", areaName + ".yml");
            if(!file.exists()) {
                file.createNewFile();
            }
            configuration = YamlConfiguration.loadConfiguration(file);
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[SurvivalBattleTeam] " + e.getMessage());
        }
    }

    public static void save() {
        try {
            configuration.save(file);
            reload();
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[SurvivalBattleTeam] ]" + e.getMessage());
        }
    }

    public static void reload() {
        configuration = YamlConfiguration.loadConfiguration(file);
    }
}
