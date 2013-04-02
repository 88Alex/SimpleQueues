package com.github.ethg242.simplequeues;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.*;
import org.bukkit.event.*;
import org.bukkit.configuration.file.FileConfiguration;

public final class SimpleQueues extends JavaPlugin {
	public String[] queue = null;
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		
		
		getCommand("qcreate").setExecutor(new CmdCreateExecutor(this));
		getCommand("qlist").setExecutor(new CmdListExecutor(this));
		getCommand("qadd").setExecutor(new CmdAddExecutor(this));
		getCommand("qremove").setExecutor(new CmdRemoveExecutor(this));
		getCommand("qreset").setExecutor(new CmdResetExecutor(this));
	}
}

//
//  TO DO:
// -multiple queues- array of arrays?
// -do something when full
// -configurable; config file
// -on player logout, remove from queue
//
//  BUGS:
// -bug
//