package me.harvest.qLogger.commands;

import me.harvest.qLogger.QLogger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(strings[0].equalsIgnoreCase("reload")) {
            if (commandSender.hasPermission("QLogger.admin") || commandSender.isOp()) {
                QLogger.getInstance().reloadConfig();
            }
        }
        return true;
    }
}
