package me.charon.staffessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;

public class kick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
       if (sender instanceof Player){
        Player player = (Player) sender;
        Player target = Bukkit.getServer().getPlayer(args[0]);
        String playerName = player.getName();
        String targetName = target.getName();
        StringBuilder message = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            message.append(args[i]).append(" ");
        }
        message = new StringBuilder(message.toString().trim());
        if (command.getName().equalsIgnoreCase("kick")){
            if(!player.hasPermission("se.kick") || player.isOp()) {
                if (args.length == 1) {
                    target.kickPlayer(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "*" + ChatColor.GRAY + "] " + ChatColor.WHITE + "You have been kicked from server!");
                    Bukkit.broadcastMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "----------------------------------------------" + ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "!" + ChatColor.GRAY + "] " + ChatColor.DARK_PURPLE + targetName + ChatColor.WHITE + " has been kicked from server by " + ChatColor.DARK_PURPLE + playerName + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "\n----------------------------------------------");
                } else if (args.length >= 2) {
                    target.kickPlayer(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "*" + ChatColor.GRAY + "] " + ChatColor.WHITE + "You have been kicked from server!\n" + ChatColor.DARK_PURPLE + "Reason: " + ChatColor.WHITE + message);
                    Bukkit.broadcastMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "----------------------------------------------\n" + ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "!" + ChatColor.GRAY + "] " + ChatColor.DARK_PURPLE + targetName + ChatColor.WHITE + " has been kicked from server by " + ChatColor.DARK_PURPLE + playerName + "\n" + ChatColor.DARK_PURPLE + "Reason:" + ChatColor.WHITE + message + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "\n----------------------------------------------");
                }
            } else {
                player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "*" + ChatColor.GRAY + "] " + ChatColor.WHITE + "You don't have permission to run this command!");
            }
        }

        } else{
           System.out.println("[*] You have to run this command as player!");
       }
        return false;
    }
}
