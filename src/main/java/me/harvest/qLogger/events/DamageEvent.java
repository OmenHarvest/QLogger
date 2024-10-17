package me.harvest.qLogger.events;

import me.harvest.qLogger.QLogger;
import me.harvest.qLogger.logger.LogType;
import me.harvest.qLogger.utils.TextUtils;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DamageEvent implements Listener {

    private final LogType logType = LogType.DAMAGE;

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof LivingEntity) {
            if (QLogger.getInstance().getConfig().getBoolean("damage_log.damage_by_entity_log")) {
                Player player = (Player) event.getEntity();

                String generated_message = String.format("%s damaged by %s | damage: %f", player.getName(), event.getDamager().getName(), event.getDamage());

                QLogger.getInstance().getLogManager().pullGeneratedMessage(logType, generated_message, QLogger.getInstance());
            }
        }
        else if (QLogger.getInstance().getConfig().getBoolean("damage_log.damage_by_player_log")) {
            if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
                Player player = (Player) event.getEntity();

                String generated_message = String.format("%s damaged by %s | damage: %f", player.getName(), event.getDamager().getName(), event.getDamage());

                QLogger.getInstance().getLogManager().pullGeneratedMessage(logType, generated_message, QLogger.getInstance());
            }
        }
    }


}
