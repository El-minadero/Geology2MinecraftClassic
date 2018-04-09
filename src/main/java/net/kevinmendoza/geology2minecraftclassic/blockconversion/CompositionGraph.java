package net.kevinmendoza.geology2minecraftclassic.blockconversion;

import java.util.List;

import org.spongepowered.api.block.BlockState;

import net.kevinmendoza.geoworldlibrary.geology.rockdata.IRetrieveData;

public class CompositionGraph {
	
	private IBlockBase startingNode;
	
	private List<IBlockBase> Nodes;

	public BlockState getBlockState(IRetrieveData retrievalData) {
		return startingNode.getBlockState(retrievalData);
	}

}
