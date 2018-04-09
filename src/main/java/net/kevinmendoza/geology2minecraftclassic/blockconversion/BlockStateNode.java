package net.kevinmendoza.geology2minecraftclassic.blockconversion;

import java.util.List;

import org.spongepowered.api.block.BlockState;

import net.kevinmendoza.geoworldlibrary.geology.rockdata.ActivityModifiers;
import net.kevinmendoza.geoworldlibrary.geology.rockdata.IRetrieveData;

class BlockStateNode implements IBlockBase {

	private double[] activityTransformingThresholds;
	private double[] activityStartingValue;
	private List<IBlockBase> transformThresholds;
	
	public BlockState getBlockState(IRetrieveData retrievalData) {
		for(ActivityModifiers modifier : ActivityModifiers.values()) {
			if(activityTransformingThresholds[modifier.ordinal()]> -1) {
				if(activityTransformingThresholds[modifier.ordinal()] 
						< retrievalData.getModifierValue(modifier)) {
					return transformThresholds.get(modifier.ordinal())
							.getBlockState(retrievalData,this);
				}
			}
		}
	}

	@Override
	public BlockState getBlockState(IRetrieveData retrievalData, 
			BlockStateNode blockStateNode) {
		// TODO Auto-generated method stub
		return null;
	}

}
