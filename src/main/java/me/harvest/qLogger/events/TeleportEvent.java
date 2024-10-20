package me.harvest.qLogger.events;

import me.harvest.qLogger.QLogger;
import me.harvest.qLogger.logger.LogType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TeleportEvent implements Listener {

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        if (QLogger.getInstance().getConfig().getBoolean("teleport_log.teleport_log")){
            if (event.getCause() == PlayerTeleportEvent.TeleportCause.PLUGIN || event.getCause() == PlayerTeleportEvent.TeleportCause.COMMAND) {
                String generated_message = String.format("%s teleport to %f %f %f from %f %f %f", event.getPlayer().getName(), event.getTo().getX(), event.getTo().getY(), event.getTo().getZ(), event.getFrom().getX(), event.getFrom().getY(), event.getFrom().getZ());
                QLogger.getInstance().getLogManager().pullGeneratedMessage(LogType.TELEPORT, generated_message, QLogger.getInstance());
            }
        }
    }

}
