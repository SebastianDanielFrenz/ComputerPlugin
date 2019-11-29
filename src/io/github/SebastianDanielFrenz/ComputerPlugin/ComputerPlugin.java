package io.github.SebastianDanielFrenz.ComputerPlugin;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.SebastianDanielFrenz.BML.core.BMLEngine;

public class ComputerPlugin extends JavaPlugin {

	public static ComputerPlugin plugin;
	public static BMLEngine engine;

	@Override
	public void onEnable() {
		plugin = this;
		if (!setupBML()) {
			getLogger().info("BML could not be found! Disabling...");
			getServer().getPluginManager().disablePlugin(this);
		}
	}

	@Override
	public void onDisable() {

	}

	public boolean setupBML() {
		RegisteredServiceProvider<BMLEngine> provider = getServer().getServicesManager()
				.getRegistration(BMLEngine.class);
		if (provider != null) {
			engine = provider.getProvider();
			return true;
		}
		return false;

	}

}
