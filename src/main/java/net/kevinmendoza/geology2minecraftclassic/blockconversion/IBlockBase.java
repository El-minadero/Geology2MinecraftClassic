package net.kevinmendoza.geology2minecraftclassic.blockconversion;

import java.util.List;

import org.spongepowered.api.block.BlockState;

import net.kevinmendoza.geoworldlibrary.geology.rockdata.BulkComposition;
import net.kevinmendoza.geoworldlibrary.geology.rockdata.IRetrieveData;

public interface IBlockBase {

	BlockState getBlockState(IRetrieveData retrievalData);
	
	void setSeed(long seed);
	
	void setTargets(List<IBlockBase> blockList);
	
	List<String> getTargets();
	
	IBlockMetadata getMetadata();
}
