package me.harvest.qLogger.events;

import me.harvest.qLogger.QLogger;
import me.harvest.qLogger.logger.LogType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class ChangeWorldEvent implements Listener {

    private final LogType logType = LogType.CHANGEWORLD;

    @EventHandler
    public void changeWorldEvent(PlayerChangedWorldEvent e) {
        if(QLogger.getInstance().getConfig().getBoolean("changed_world_log.changed_world_log")){
            String generated_message = String.format("%s enter in %s from %s", e.getPlayer().getName(), e.getPlayer().getWorld().getName(), e.getFrom().getName());

            QLogger.getInstance().getLogManager().pullGeneratedMessage(logType, generated_message, QLogger.getInstance());
        }
    }

}
