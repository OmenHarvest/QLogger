package me.harvest.qLogger.events;

import me.harvest.qLogger.QLogger;
import me.harvest.qLogger.logger.LogType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveEvent implements Listener {

    private final LogType logType = LogType.JOINLEAVE;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if(QLogger.getInstance().getConfig().getBoolean("join_leave_log.join_leave_log")){
            String generated_message = String.format("%s join on server", event.getPlayer().getName());

            QLogger.getInstance().getLogManager().pullGeneratedMessage(logType, generated_message, QLogger.getInstance());
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        if(QLogger.getInstance().getConfig().getBoolean("join_leave_log.join_leave_log")){
            String generated_message = String.format("%s leave from server", event.getPlayer().getName());

            QLogger.getInstance().getLogManager().pullGeneratedMessage(logType, generated_message, QLogger.getInstance());
        }
    }

}
