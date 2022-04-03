package me.charon.staffessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class heal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(!player.hasPermission("se.heal") || player.isOp()){
                if (args.length == 0) {
                    player.setHealth(20);
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "*" + ChatColor.GRAY + "] " + ChatColor.WHITE + " You have been healed!");
                } else if (args.length == 1) {
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    String playerName = player.getName();
                    String targetName = target.getName();
                    target.setHealth(20);
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "*" + ChatColor.GRAY + "] " + ChatColor.WHITE + " You have been healed " + ChatColor.DARK_PURPLE + targetName + ChatColor.WHITE + "!");
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "*" + ChatColor.GRAY + "] " + ChatColor.WHITE + " You have been healed by " + ChatColor.DARK_PURPLE + playerName + ChatColor.WHITE + "!");
                }
            } else {
                player.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_RED + "*" + ChatColor.GRAY + "] " + ChatColor.WHITE + "You don't have permission to run this command!");
            }
        }
        else {
            System.out.println("[*] You have to run this command as player!");
        }

        return false;
    }
}
