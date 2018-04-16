package net.kevinmendoza.geology2minecraftclassic.blockconversion.ore;

import org.spongepowered.api.block.BlockState;

import net.kevinmendoza.geoworldlibrary.geology.rockdata.IRetrieveData;

public interface IOreControl {

	void setSeed(long seed);

	boolean isOre(IRetrieveData retrievalData);

	BlockState getOre(IRetrieveData retrievalData);

}
