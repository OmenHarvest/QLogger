package me.harvest.qLogger.events;

import io.papermc.paper.event.player.AsyncChatEvent;
import me.harvest.qLogger.QLogger;
import me.harvest.qLogger.logger.LogType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatAsyncEvent implements Listener {

    private final LogType logType = LogType.CHAT;

    @EventHandler
    public void onChat(AsyncChatEvent e) {
        if(QLogger.getInstance().getConfig().getBoolean("chat_log.chat_log")){
            String generated_message = String.format("%s send message: %s", e.getPlayer(), e.message());

            QLogger.getInstance().getLogManager().pullGeneratedMessage(logType, generated_message, QLogger.getInstance());
        }
    }
}
