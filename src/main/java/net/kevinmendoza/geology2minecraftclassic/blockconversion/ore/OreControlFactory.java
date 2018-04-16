package net.kevinmendoza.geology2minecraftclassic.blockconversion.ore;

import net.kevinmendoza.geology2minecraftclassic.configuration.IBlockStateDefaults;
import net.kevinmendoza.geology2minecraftclassic.configuration.IOreControlDefaults;

public class OreControlFactory implements IOreControlFactory {

	public IOreControl createOreControl(IBlockStateDefaults defaults) {
		IOreControlDefaults oreControlDefaults = defaults.getOreControlDefaults();
		return new OreControl();
	}

}
