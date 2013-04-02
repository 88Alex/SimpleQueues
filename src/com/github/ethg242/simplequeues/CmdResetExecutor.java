package com.github.ethg242.simplequeues;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CmdResetExecutor implements CommandExecutor {
	private SimpleQueues plugin;
	public CmdResetExecutor(SimpleQueues plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String[] queue = plugin.queue;
		if (args.length == 0) {
			queue = new String[queue.length];
			return true;
		}
		return false;
	}
}
