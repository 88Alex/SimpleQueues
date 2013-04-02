package com.github.ethg242.simplequeues;

import java.util.Arrays;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdAddExecutor implements CommandExecutor {
	private SimpleQueues plugin;
	public CmdAddExecutor(SimpleQueues plugin) {
		this.plugin = plugin;
	}
	
	int nextEmpty(Object[] array) {
		int nextempty = 0;
		while (!(array[nextempty] == null)) {
			nextempty++;
		}
		return nextempty;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String[] queue = plugin.queue;
		if (args.length == 0) {
			if (sender.hasPermission("SimpleQueues.addself")) {
				if (Arrays.asList(queue).contains(sender.getName())) {
					sender.sendMessage("You are already in the queue.");
				}
				else {
					queue[nextEmpty(queue)] = sender.getName();
					sender.sendMessage("You have been added to the queue.");
				}
			}
			else {
				sender.sendMessage("You don't have permission to do this.");
			}
			return true;
		}
		else if (args.length == 1) {
			if (sender.hasPermission("SimpleQueues.addother")) {
				Player player = plugin.getServer().getPlayer(args[1]);
				if (player == null) {
					sender.sendMessage(args[1] + " is not online or is not a valid player.");
				}
				else if (Arrays.asList(queue).contains(args[0])) {
					sender.sendMessage(args[1] + " is already in the queue.");
				}
				else {
					queue[nextEmpty(queue)] = player.getName();
					sender.sendMessage(args[1] + " has been added to the queue.");
					player.sendMessage("You have been added to the queue by " + sender.getName() + ".");
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
