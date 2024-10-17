package me.harvest.qLogger;

import me.harvest.qLogger.events.DamageEvent;
import me.harvest.qLogger.events.DeathEvent;
import me.harvest.qLogger.logger.LogManager;
import me.harvest.qLogger.utils.TextUtils;
import org.bukkit.plugin.java.JavaPlugin;

public final class QLogger extends JavaPlugin {

    private static QLogger instance;
    private LogManager logManager;

    @Override
    public void onEnable() {
        QLogger.instance = this;
        saveDefaultConfig();
        logManager = new LogManager(); // main logManager channel

        loadEvents();
        TextUtils.startupWelcome();

    }

    public LogManager getLogManager() {
        return logManager;
    }

    private void loadEvents(){
        instance.getServer().getPluginManager().registerEvents(new DamageEvent(), this);
        instance.getServer().getPluginManager().registerEvents(new DeathEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static QLogger getInstance() {
        return instance;
    }
}
