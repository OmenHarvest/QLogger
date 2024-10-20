package me.harvest.qLogger;

import io.papermc.paper.command.brigadier.Commands;
import me.harvest.qLogger.commands.ReloadCommand;
import me.harvest.qLogger.events.*;
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
        if(this.getConfig().getBoolean("telegram_module")) {
            telegram = new TelegramSenderModule();
        }

        loadEvents();
        regCommands();
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
        instance.getServer().getPluginManager().registerEvents(new JoinLeaveEvent(), this);
        instance.getServer().getPluginManager().registerEvents(new ChangeWorldEvent(), this);
    }

    private void regCommands(){
        getCommand("QLogger").setExecutor(new ReloadCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static QLogger getInstance() {
        return instance;
    }
}
