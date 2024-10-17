package me.harvest.qLogger.utils;

import me.harvest.qLogger.QLogger;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

//class for logging in telegram bot. You can change private policy in config instr. Default = off
public class TelegramSenderModule {

    private List<String> telegramMessagesContainer = new ArrayList<>();

    public TelegramSenderModule() {
        new BukkitRunnable() {
            public void run() {
                if(telegramMessagesContainer.isEmpty()) {
                    return;
                }
                sendContainer();
                telegramMessagesContainer.clear();
            }
        }.runTaskTimerAsynchronously(QLogger.getInstance(), 1200, 1200);
    }

    public void pullMessage(String message) {
        //placeholder
        //Simple logic: in 30-60 sec (1200 ticks)  module pull message to data to share container and send it in time out

    }

    private void sendContainer() {

    }

}
