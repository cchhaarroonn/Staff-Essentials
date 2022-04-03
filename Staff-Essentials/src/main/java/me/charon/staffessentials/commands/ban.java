package me.charon.staffessentials.commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;

public class ban implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            Player target = Bukkit.getServer().getPlayer(args[0]);
            String playerName = player.getName();
            String targetName = target.getName();
            String message = "";
            for (int i = 1; i < args.length; i++) {
                message = message + args[i] + " ";
            }
            message = message.trim();
            if (!player.hasPermission("se.ban") || player.isOp()) {
                if (command.getName().equalsIgnoreCase("ban")) {
                    if (args.length == 1) {
                        target.kickPlayer(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "!" + ChatColor.GRAY + "] " + ChatColor.WHITE + "You have been banned from server!");
                        Bukkit.getServer().getBanList(BanList.Type.NAME).addBan(targetName, "None", null, playerName);
                        Bukkit.broadcastMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "----------------------------------------------\n" + ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "!" + ChatColor.GRAY + "] " + ChatColor.DARK_PURPLE + targetName + ChatColor.WHITE + " has been banned from server by " + ChatColor.DARK_PURPLE + playerName + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "\n----------------------------------------------");
                    } else if (args.length >= 2) {
                        target.kickPlayer(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "!" + ChatColor.GRAY + "] " + ChatColor.WHITE + "You have been banned from server!\n" + ChatColor.DARK_PURPLE + "Reason: " + ChatColor.WHITE + message);
                        Bukkit.getServer().getBanList(BanList.Type.NAME).addBan(targetName, message, null, playerName);
                        Bukkit.broadcastMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "----------------------------------------------\n" + ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "!" + ChatColor.GRAY + "] " + ChatColor.DARK_PURPLE + targetName + ChatColor.WHITE + " has been banned from server by " + ChatColor.DARK_PURPLE + playerName + "\n" + ChatColor.DARK_PURPLE + "Reason:" + ChatColor.WHITE + message + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "\n----------------------------------------------");
                    }
                }
            } else {
                player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "*" + ChatColor.GRAY + "] " + ChatColor.WHITE + "You don't have permission to run this command!");
            }

        } else{
            System.out.println("[*] You have to run this command as player!");
        }
        return false;
    }
}
