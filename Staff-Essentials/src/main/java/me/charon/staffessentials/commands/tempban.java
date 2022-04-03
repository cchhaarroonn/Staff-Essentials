package me.charon.staffessentials.commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.Date;

public class tempban implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            Player target = Bukkit.getServer().getPlayer(args[0]);
            String playerName = player.getName();
            String targetName = target.getName();
            String message = "";
            for (int i = 4; i < args.length; i++) {
                message = message + args[i] + " ";
            }
            message = message.trim();
            if (!player.hasPermission("se.tempban") || player.isOp()) {
                if (command.getName().equalsIgnoreCase("tempban")) {
                    if (args.length >= 3) {
                        if (args[3] == "seconds") {
                            String seconds = args[2];
                            target.kickPlayer(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "!" + ChatColor.GRAY + "] " + ChatColor.WHITE + "You have been banned from server!\n\n" + ChatColor.DARK_PURPLE + "Reason: " + ChatColor.WHITE + message + ChatColor.DARK_PURPLE + "Time: " + ChatColor.WHITE + args[2] + args[3]);
                            Bukkit.getServer().getBanList(BanList.Type.NAME).addBan(targetName, message, new Date(System.currentTimeMillis() + Long.valueOf(seconds) * 1000), playerName);
                        } else if (args[3] == "minutes") {
                            String minutes = args[2];
                            int seconds = Integer.valueOf(minutes) * 60;
                            target.kickPlayer(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "!" + ChatColor.GRAY + "] " + ChatColor.WHITE + "You have been banned from server!\n\n" + ChatColor.DARK_PURPLE + "Reason: " + ChatColor.WHITE + message + ChatColor.DARK_PURPLE + "Time: " + ChatColor.WHITE + args[2] + args[3]);
                            Bukkit.getServer().getBanList(BanList.Type.NAME).addBan(targetName, message, new Date(System.currentTimeMillis() + Long.valueOf(seconds) * 1000), playerName);
                        } else if (args[3] == "hours") {
                            String hours = args[2];
                            int minutes = Integer.valueOf(hours) * 60;
                            int seconds = minutes * 60;
                            target.kickPlayer(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "!" + ChatColor.GRAY + "] " + ChatColor.WHITE + "You have been banned from server!\n\n" + ChatColor.DARK_PURPLE + "Reason: " + ChatColor.WHITE + message + ChatColor.DARK_PURPLE + "Time: " + ChatColor.WHITE + args[2] + args[3]);
                            Bukkit.getServer().getBanList(BanList.Type.NAME).addBan(targetName, message, new Date(System.currentTimeMillis() + Long.valueOf(seconds) * 1000), playerName);
                        } else if (args[3] == "days") {
                            String days = args[2];
                            int hours = Integer.valueOf(days) * 24;
                            int minutes = hours * 60;
                            int seconds = minutes * 60;
                            target.kickPlayer(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "!" + ChatColor.GRAY + "] " + ChatColor.WHITE + "You have been banned from server!\n\n" + ChatColor.DARK_PURPLE + "Reason: " + ChatColor.WHITE + message + ChatColor.DARK_PURPLE + "Time: " + ChatColor.WHITE + args[2] + args[3]);
                            Bukkit.getServer().getBanList(BanList.Type.NAME).addBan(targetName, message, new Date(System.currentTimeMillis() + Long.valueOf(seconds) * 1000), playerName);
                        }
                    }
                } else {
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "*" + ChatColor.GRAY + "] " + ChatColor.WHITE + "You don't have permission to run this command!");
                }
            } else {
                System.out.println("[*] You have to run this command as player!");
            }
        }
        return false;
    }
}