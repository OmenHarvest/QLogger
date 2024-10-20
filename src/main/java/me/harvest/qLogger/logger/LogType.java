package me.harvest.qLogger.logger;

import me.harvest.qLogger.QLogger;

public enum LogType {

    DEATH(QLogger.getInstance().getConfig().getString("death_log.log_prefix"), new int[]{231, 76, 60}),
    DAMAGE(QLogger.getInstance().getConfig().getString("damage_log.log_prefix"), new int[] {155, 89, 182}),
    //WARN() warn logtype
    JOINLEAVE(QLogger.getInstance().getConfig().getString("join_leave_log.log_prefix"), new int[] {253, 167, 223}),
    CHANGEWORLD(QLogger.getInstance().getConfig().getString("changed_world_log.log_prefix"), new int[] {0, 98, 102}),
    CHAT(QLogger.getInstance().getConfig().getString("chat_log.log_prefix"), new int[] {126, 214, 223}),
    TELEPORT(QLogger.getInstance().getConfig().getString("teleport_log.log_prefix"), new int[] {255, 168, 1}),
    TELEGRAM("[Telegram]", new int[] {6, 82, 221}),
    ERROR("TEST/ERROR", new int[]{231, 76, 60});

    private final String prefix;
    private final int[] colorRGBContainer;

    private LogType(String prefix, int[] colorRGBContainer) {
        this.prefix = prefix;
        this.colorRGBContainer = colorRGBContainer;
    }

    public String getPrefix() {
        return prefix;
    }

    public int[] getColorRGBContainer() {
        return colorRGBContainer;
    }
}
