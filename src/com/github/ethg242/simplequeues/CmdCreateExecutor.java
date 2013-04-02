package com.github.ethg242.simplequeues;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CmdCreateExecutor implements CommandExecutor {
	private SimpleQueues plugin;
	public CmdCreateExecutor(SimpleQueues plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String[] queue = plugin.queue;
		if (args.length == 0) {
			queue = new String[10];
			sender.sendMessage("New queue created with size 5.");
		}
		else if (args.length == 1) {
			int in = Integer.parseInt(args[0]) * 2;
			queue = new String[in];
			sender.sendMessage("New queue created with size " + args[0] + ".");
		}
		else {
			return false;
		}
		return true;
	}
}
