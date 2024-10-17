package me.harvest.qLogger.events;

import me.harvest.qLogger.QLogger;
import me.harvest.qLogger.logger.LogType;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {

    private final LogType logType = LogType.DEATH;

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        if(QLogger.getInstance().getConfig().getBoolean("damage_log.damage_by_entity_log")){
            String generated_message;
            if(event.getEntity().getKiller() == null){
                generated_message = String.format("%s killed by world environment. | %f %f %f", event.getEntity().getName(), event.getPlayer().getLocation().getX(), event.getPlayer().getLocation().getY(), event.getPlayer().getLocation().getZ());
            }
            else {
                generated_message = String.format("%s killed by %s. | %f %f %f", event.getEntity().getName(), event.getEntity().getKiller(), event.getPlayer().getLocation().getX(), event.getPlayer().getLocation().getY(), event.getPlayer().getLocation().getZ()); //bug cause
            }
            QLogger.getInstance().getLogManager().pullGeneratedMessage(logType, generated_message, QLogger.getInstance());
        }
    }
}
