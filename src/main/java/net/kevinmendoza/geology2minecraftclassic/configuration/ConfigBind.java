package net.kevinmendoza.geology2minecraftclassic.configuration;

import com.google.inject.AbstractModule;

public class ConfigBind extends AbstractModule {

	@Override
	protected void configure() {
		bind(IGlobalDefaults.class).to(GlobalDefaults.class);
	}

}
