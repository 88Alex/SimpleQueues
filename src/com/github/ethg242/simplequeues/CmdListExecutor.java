package com.github.ethg242.simplequeues;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CmdListExecutor implements CommandExecutor {
	private SimpleQueues plugin;
	public CmdListExecutor(SimpleQueues plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String[] queue = plugin.queue;
		if (args.length == 0) {
			sender.sendMessage("Current queue:");
			for (int pos=0; pos < queue.length; pos+=2) {
				String form1 = queue[pos];
				String form2 = queue[pos+1];
				if (form1 == null) {
					form1 = "----";
				}
				if (form2 == null) {
					form2 = "----";
				}
				sender.sendMessage(String.format("%1$-16s", form1) + form2);
			}
			return true;
		}
		return false;
	}
}
