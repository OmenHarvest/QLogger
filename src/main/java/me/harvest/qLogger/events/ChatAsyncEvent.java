package me.harvest.qLogger.events;

import com.destroystokyo.paper.event.brigadier.AsyncPlayerSendCommandsEvent;
import io.papermc.paper.event.player.AsyncChatEvent;
import me.harvest.qLogger.QLogger;
import me.harvest.qLogger.logger.LogType;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;

public class ChatAsyncEvent implements Listener {

    private final LogType logType = LogType.CHAT;

    @EventHandler
    public void onChat(AsyncChatEvent e) {
        if(QLogger.getInstance().getConfig().getBoolean("chat_log.chat_log")){
            String generated_message = String.format("%s send message: %s", e.getPlayer().getName(), PlainTextComponentSerializer.plainText().serialize(e.originalMessage()));

            QLogger.getInstance().getLogManager().pullGeneratedMessage(logType, generated_message, QLogger.getInstance());
        }
    }

    @EventHandler
    public void onPlayerChat(PlayerCommandSendEvent e) {
        if(QLogger.getInstance().getConfig().getBoolean("chat_log.command_log")){
            String generated_message = String.format("%s send message: %s", e.getPlayer().getName(), "placholder");

            QLogger.getInstance().getLogManager().pullGeneratedMessage(logType, generated_message, QLogger.getInstance());
        }
    }
}
