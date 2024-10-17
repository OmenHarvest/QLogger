package me.harvest.qLogger;

import me.harvest.qLogger.events.DamageEvent;
import me.harvest.qLogger.utils.TextUtils;
import org.bukkit.plugin.java.JavaPlugin;

public final class QLogger extends JavaPlugin {

    private static QLogger instance;
    @Override
    public void onEnable() {
        QLogger.instance = this;
        saveDefaultConfig();

        loadEvents();
        TextUtils.startupWelcome();

    }

    private void loadEvents(){
        instance.getServer().getPluginManager().registerEvents(new DamageEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static QLogger getInstance() {
        return instance;
    }
}
