package net.kevinmendoza.geology2minecraftclassic.blockconversion.state;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.Diff;
import org.spongepowered.api.block.BlockState;

import net.kevinmendoza.geology2minecraftclassic.configuration.IBlockStateAccessDefaults;
import net.kevinmendoza.geology2minecraftclassic.configuration.IBlockStateDefaults;

public class StateAccessFactory {
	
	private BlockStateFactory blockStateFactory;
	
	public StateAccessFactory() {
		blockStateFactory= new BlockStateFactory();
	}

	public IBlockStateAccess createBlockStateAccess(IBlockStateDefaults defaults) {
		IBlockStateAccessDefaults accessDefaults= defaults.getAccessDefaults();
		IBlockStateAccess access = null;
		if(accessDefaults.isSingleState()) {
			String type 		= accessDefaults.getTypes().get(0);
			String variant 	= accessDefaults.getVariants().get(0);
			access = new SingleStateAccess.Builder()
			.setState(blockStateFactory.getBlockState(type,variant))
			.build();
		}
		else {
			List<String> types  			= accessDefaults.getTypes();
			List<String> variants 		= accessDefaults.getVariants();
			double[]     probabilities 	= accessDefaults.getProbabilities();
			
 			variants 	 	= checkVariants(types,variants);
			probabilities 	= checkProbabilities(types,probabilities);
			
			List<BlockState> states = prepareBlockStates(types,variants);
			
			access = new MultiStateAccess.Builder()
					.setStates(states)
					.setProbabilities(probabilities)
					.build();
		}
		return access;
	}

	private List<BlockState> prepareBlockStates(List<String> types, List<String> variants) {
		List<BlockState> states = new ArrayList<>();
		for(int i=0;i<types.size();i++) {
			states.add(blockStateFactory.getBlockState(types.get(i), variants.get(i)));
		}
		return states;
	}

	private double[] checkProbabilities(List<String> types, double[] probabilities) {
		int typeSize = types.size();
		int probSize = probabilities.length;
		if (typeSize > probSize) {
			probabilities = createDummyProbabilityArray(probabilities, typeSize, probSize);
		}
		return probabilities;
	}

	private List<String> checkVariants(List<String> types, List<String> variants) {
		int typeSize = types.size();
		int variantSize = variants.size();
		if (typeSize > variantSize) {
			createDummyVariants(variants, typeSize, variantSize);
		}
		return variants;
	}

	private void createDummyVariants(List<String> variants, int typeSize, int variantSize) {
		int diff = typeSize - variantSize;
		for(int i =0;i<diff;i++) {
			variants.add("DEFAULT");
		}
	}
	
	private double[] createDummyProbabilityArray(double[] probabilities, int typeSize, int probSize) {
		int diff = typeSize - probSize;
		double[] newProb = new double[typeSize];
		for(int i=0;i<probSize;i++) {
			newProb[i] = probabilities[i];
		}
		for(int i =probabilities.length; i<probabilities.length+diff;i++) {
			newProb[i] = 1.0/diff;
		}
		probabilities=newProb;
		return probabilities;
	}
}
