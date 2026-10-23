package dev.tdmnhat.plugin.file;

import dev.tdmnhat.plugin.SurvivalTeamBattle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class GlobalConfigFile {

    private static File file;
    private static FileConfiguration configuration;
    private static SurvivalTeamBattle plugin;

    public static void setup() {
        try {
            plugin = (SurvivalTeamBattle) Bukkit.getPluginManager().getPlugin("SurvivalTeamBattle");
            file = new File(plugin.getDataFolder(), "global-config.yml");
            if(!file.exists()) {
                file.createNewFile();
            }
            configuration = YamlConfiguration.loadConfiguration(file);
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[SurvivalTeamBattle] " + e.getMessage());
        }
    }

    public static FileConfiguration getConfiguration() {
        return configuration;
    }

    public static void save() {
        try {
            configuration.save(file);
            reload();
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[SurvivalTeamBattle] " + e.getMessage());
        }
    }

    public static void reload() {
        configuration = YamlConfiguration.loadConfiguration(file);
    }
}
