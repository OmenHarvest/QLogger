package me.harvest.qLogger.commands;

import me.harvest.qLogger.QLogger;
import me.harvest.qLogger.utils.TextUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(strings.length < 1 && (commandSender.hasPermission("QLogger.admin") || commandSender.isOp())) {
            TextUtils.startupWelcome();
            return true;
        }
        if(strings[0].equals("reload")) {
            if (commandSender.hasPermission("QLogger.admin") || commandSender.isOp()) {
                QLogger.getInstance().reloadConfig();
                TextUtils.MessageSend(commandSender, "[QLogger]", "config reloaded", 87, 95, 207);
            }
        }
        return true;
    }
}
