package com.github.ethg242.simplequeues;

import java.util.Arrays;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdRemoveExecutor implements CommandExecutor {
	private SimpleQueues plugin;	 
	public CmdRemoveExecutor(SimpleQueues plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String[] queue = plugin.queue;
		if (args.length == 0) {
			if (sender.hasPermission("SimpleQueues.removeself")) {
				if (!(Arrays.asList(queue).contains(sender.getName()))) {
					sender.sendMessage("You are not in the queue.");
				}
				else {
					for (int pos = 0; pos < queue.length; pos++) {
						if (queue[pos] == sender.getName()) {
							queue[pos] = null;
						}
					}
					sender.sendMessage("You have been removed from the queue.");
				}
			}
			else {
				sender.sendMessage("You don't have permission to do this.");
			}
			return true;
		}
		else if (args.length == 2) {
			if (sender.hasPermission("SimpleQueues.removeother")) {
				Player player = plugin.getServer().getPlayer(args[1]);
				if (player == null) {
					sender.sendMessage(args[1] + " is not online or is not a valid player.");
				}
				else if (!(Arrays.asList(queue).contains(player.getName()))) {
					sender.sendMessage(args[1] + " is not in the queue.");
				}
				else {
					for (int pos = 0; pos < queue.length; pos++) {
						if (queue[pos] == args[1]) {
							queue[pos] = null;
						}
					}
					sender.sendMessage(args[1] + " has been removed from the queue.");
					player.sendMessage("You have been removed from the queue by " + sender.getName() + ".");
				}
			}
			else {
				sender.sendMessage("You don't have permission to do this.");
			}
			return true;
		}
		return false;
	}
}
