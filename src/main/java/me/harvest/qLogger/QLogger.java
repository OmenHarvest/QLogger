package me.harvest.qLogger;

import me.harvest.qLogger.utils.TextUtils;
import org.bukkit.plugin.java.JavaPlugin;

public final class QLogger extends JavaPlugin {

    private static QLogger instance;
    @Override
    public void onEnable() {
        QLogger.instance = this;
        saveDefaultConfig();

        TextUtils.startupWelcome();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
