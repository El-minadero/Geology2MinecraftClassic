package net.kevinmendoza.geology2minecraftclassic.blockconversion.metamorphic;

import java.util.List;

import org.spongepowered.api.block.BlockState;

import net.kevinmendoza.geology2minecraftclassic.blockconversion.IBlockBase;
import net.kevinmendoza.geoworldlibrary.geology.rockdata.IRetrieveData;

public interface IMetaControl {

	boolean shouldConvert(IRetrieveData retrievalData);

	BlockState returnConvertedNodeBlockState(IRetrieveData retrievalData);

	void setSeed(long seed);
	
	void setTargets(List<IBlockBase> blockList);
	
	List<String> getTargets();

}
