package dev.tdmnhat.plugin;

import dev.tdmnhat.plugin.command.AdminCommand;
import dev.tdmnhat.plugin.command.MainCommand;
import dev.tdmnhat.plugin.file.GlobalConfigFile;
import org.bukkit.plugin.java.JavaPlugin;

public final class SurvivalTeamBattle extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerConfig();

        registerListener();

        registerCommand();
    }

    private void registerConfig() {
        // config.yml
        this.getConfig().options().copyDefaults(true);
        saveConfig();

        // global-config.yml
        GlobalConfigFile.setup();
        GlobalConfigFile.getConfiguration().options().copyDefaults(true);
        GlobalConfigFile.save();
    }

    private void registerListener() {

    }

    private void registerCommand() {
        this.getCommand("stb").setExecutor(new MainCommand());
        this.getCommand("stb").setExecutor(new AdminCommand());
    }
}
