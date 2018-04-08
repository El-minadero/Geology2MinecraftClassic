package net.kevinmendoza.geology2minecraftclassicmain;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.GameReloadEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

import com.google.inject.Inject;

import net.kevinmendoza.geology2minecraftclassic.configuration.GlobalDefaults;
import net.kevinmendoza.geoworldlibrary.geology.recursivegeology.IGeology;
import net.kevinmendoza.geoworldlibrary.utilities.IBlockStateCreator;
import net.kevinmendoza.geoworldlibrary.utilities.IGeoWorldPlugin;
import net.kevinmendoza.geoworldlibrary.utilities.IGeoWorldRockTransformer;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;

@Plugin(
id=Geology2MinecraftClassicMain.ID,
name=Geology2MinecraftClassicMain.NAME,
version=Geology2MinecraftClassicMain.VERSION,
url="http://www.kevinmendoza.net/geoworld-a-minecraft-geology-addon/",
authors = {"El_Minadero"},
description = "A Geologic Minecraft Mod",
dependencies = @Dependency(id = "geoworld", optional = false))
public class Geology2MinecraftClassicMain implements IGeoWorldRockTransformer {
	public static final String ID = "geology2minecraftclassic";
	public static final String NAME = "Geology 2 Minecraft Classic";
	public static final String VERSION = "1.0.1a";
	public static Geology2MinecraftClassicMain PluginMain;
	private GlobalDefaults defaults;
	@Inject
	private Logger logger; 
	@Inject 
	private PluginContainer container;
	@Inject @DefaultConfig(sharedRoot = true)
	private File file; 
	@Inject @DefaultConfig(sharedRoot = true) 
	private ConfigurationLoader<CommentedConfigurationNode> loader;
	
	public Geology2MinecraftClassicMain() {
		PluginMain = this;
	}
	@Listener
	public void onGamePreInitialization(GamePreInitializationEvent event) throws IOException, ObjectMappingException {
	 createConfigs();
	}
	
	@Listener
	public void onGameReload(GameReloadEvent event) throws IOException, ObjectMappingException {
		createConfigs();
	}

	public void createConfigs() throws IOException, ObjectMappingException {
		ConfigurationNode node = loader.createEmptyNode();
		node.setValue(GlobalDefaults.type, defaults == null ? (defaults= new GlobalDefaults()) : defaults);
		loader.save(node);
	}
	
	public PluginContainer GetPluginContainer() {
		return container;
	}

	public Logger GetLog() {
		return logger;
	}

	@Override
	public String GetPluginID() { return ID; }
	
	@Override
	public IBlockStateCreator getBlockCreator(long seed, boolean newInstance) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
