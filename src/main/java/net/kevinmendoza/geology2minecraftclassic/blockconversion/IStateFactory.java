package net.kevinmendoza.geology2minecraftclassic.blockconversion;

import net.kevinmendoza.geology2minecraftclassic.configuration.IBlockStateDefaults;

public interface IStateFactory {

	public IBlockBase createState(IBlockStateDefaults defaults);
}
