package net.kevinmendoza.geology2minecraftclassic.blockconversion;

import java.util.HashMap;

import org.spongepowered.api.block.BlockState;

import com.google.inject.Inject;

import net.kevinmendoza.geology2minecraftclassic.configuration.IGlobalDefaults;
import net.kevinmendoza.geoworldlibrary.geology.rockdata.BulkComposition;
import net.kevinmendoza.geoworldlibrary.geology.rockdata.IData;
import net.kevinmendoza.geoworldlibrary.geology.rockdata.IRetrieveData;
import net.kevinmendoza.geoworldlibrary.utilities.IBlockStateCreator;
class BlockConverter implements IBlockStateCreator {
	 
	private HashMap<BulkComposition,CompositionGraph> blockMap;

	@Override
	public BlockState getBlockState(IData data) {
		IRetrieveData retrievalData = (IRetrieveData)data;
		return blockMap.get(retrievalData.getComposition())
				.getBlockState(retrievalData);
	}
	
}
