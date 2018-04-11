package net.kevinmendoza.geology2minecraftclassic.blockconversion;

import org.spongepowered.api.block.BlockState;

import net.kevinmendoza.geoworldlibrary.geology.rockdata.IRetrieveData;

interface IBlockBase {

	BlockState getBlockState(IRetrieveData retrievalData);
	
	void setSeed(long seed);

}
