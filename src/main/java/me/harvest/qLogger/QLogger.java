package me.harvest.qLogger;

import org.bukkit.plugin.java.JavaPlugin;

public final class QLogger extends JavaPlugin {

    private static QLogger instance;
    @Override
    public void onEnable() {
        QLogger.instance = this;
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
