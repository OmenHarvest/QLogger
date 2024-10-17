package me.harvest.qLogger;

import me.harvest.qLogger.events.ChatAsyncEvent;
import me.harvest.qLogger.events.DamageEvent;
import me.harvest.qLogger.events.DeathEvent;
import me.harvest.qLogger.logger.LogManager;
import me.harvest.qLogger.utils.TelegramSenderModule;
import me.harvest.qLogger.utils.TextUtils;
import org.bukkit.plugin.java.JavaPlugin;

public final class QLogger extends JavaPlugin {

    private static QLogger instance;
    private LogManager logManager;
    private TelegramSenderModule telegram;

    @Override
    public void onEnable() {
        QLogger.instance = this;
        saveDefaultConfig();
        logManager = new LogManager(); // main logManager channel
        telegram = new TelegramSenderModule();

        loadEvents();
        TextUtils.startupWelcome();
        TextUtils.TimerControl();

    }

    public TelegramSenderModule getTelegram() {
        return telegram;
    }

    public LogManager getLogManager() {
        return logManager;
    }

    private void loadEvents(){
        instance.getServer().getPluginManager().registerEvents(new DamageEvent(), this);
        instance.getServer().getPluginManager().registerEvents(new DeathEvent(), this);
        instance.getServer().getPluginManager().registerEvents(new ChatAsyncEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static QLogger getInstance() {
        return instance;
    }
}
