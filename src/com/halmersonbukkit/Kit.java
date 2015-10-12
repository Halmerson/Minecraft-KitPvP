package com.halmersonbukkit;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Kit extends JavaPlugin {

	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Listeners(), this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Come on! Your a Console! How can you equip a kit????");
			return true;
		}


		Player p = (Player) sender;
		PlayerInventory pi = p.getInventory();

		if (command.getName().equalsIgnoreCase("kit")) {
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("fighter")) {
					ItemStack[] iron = {new ItemStack(Material.IRON_HELMET), new ItemStack(Material.IRON_CHESTPLATE), new ItemStack(Material.IRON_LEGGINGS), new ItemStack(Material.IRON_BOOTS)};
					p.getInventory().setArmorContents(iron);
					pi.clear();
					pi.addItem(new ItemStack(Material.STONE_SWORD));
					p.sendMessage(ChatColor.GREEN + "You have equipped kit " + ChatColor.RED + "Fighter");
				}

				if (args[0].equalsIgnoreCase("heavy")) {
					ItemStack[] diamond = {new ItemStack(Material.DIAMOND_HELMET), new ItemStack(Material.DIAMOND_CHESTPLATE), new ItemStack(Material.DIAMOND_LEGGINGS), new ItemStack(Material.DIAMOND_BOOTS)};
					p.getInventory().setArmorContents(diamond);
					pi.clear();
					pi.addItem(new ItemStack(Material.WOOD_SWORD));
					p.sendMessage(ChatColor.GREEN + "You have equipped kit " + ChatColor.RED + "Heavy");
					return true;
				}
				if (args[0].equalsIgnoreCase("archer")) {
					ItemStack[] chainmail = {new ItemStack(Material.CHAINMAIL_HELMET), new ItemStack(Material.CHAINMAIL_CHESTPLATE), new ItemStack(Material.CHAINMAIL_LEGGINGS), new ItemStack(Material.CHAINMAIL_BOOTS)};
					p.getInventory().setArmorContents(chainmail);
					pi.clear();
					pi.addItem(new ItemStack(Material.STONE_SWORD));
					ItemStack ArcherBow = new ItemStack(Material.BOW);
					ArcherBow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
					ArcherBow.addEnchantment(Enchantment.ARROW_FIRE, 1);
					ArcherBow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
					pi.addItem(ArcherBow);
					pi.addItem(new ItemStack(Material.ARROW));
					p.sendMessage(ChatColor.GREEN + "You have equipped kit " + ChatColor.RED + "Archer");
				}
			}
		} else {
			p.sendMessage(ChatColor.RED + "Kit: " + ChatColor.GREEN + "Fighter " + ChatColor.RED + "+ " + ChatColor.GREEN + "Archer " + ChatColor.RED + "+ " + ChatColor.GREEN + "Heavy");
		}
		return true;
	}
}