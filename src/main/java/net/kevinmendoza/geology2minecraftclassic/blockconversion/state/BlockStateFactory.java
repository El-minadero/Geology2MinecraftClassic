package net.kevinmendoza.geology2minecraftclassic.blockconversion.state;

import net.kevinmendoza.geology2minecraftclassic.configuration.IBlockStateAccessDefaults;
import net.kevinmendoza.geology2minecraftclassic.configuration.IBlockStateDefaults;

public class BlockStateFactory {
	
	private BlockTypeFactory blockTypeFactory;
	
	
	public BlockStateFactory() {
		blockTypeFactory = new BlockTypeFactory();
	}

	public IBlockStateAccess createBlockStateAccess(IBlockStateDefaults defaults) {
		IBlockStateAccessDefaults accessDefaults= defaults.getAccessDefaults();
		return null;
	}

}
