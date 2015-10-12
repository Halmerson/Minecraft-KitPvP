package com.halmersonbukkit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Listeners implements Listener {
	
	@EventHandler
	public void onPlayerDeath (PlayerDeathEvent e){
		Player p = e.getEntity().getPlayer();
		Bukkit.broadcastMessage(ChatColor.BOLD + "Player " + ChatColor.RED + "" + ChatColor.BOLD + p.getName() + ChatColor.WHITE + ChatColor.BOLD + " Has been killed by " + ChatColor.RED + "" + ChatColor.BOLD + p.getKiller().getName());
	}

}
