 package net.kevinmendoza.geology2minecraftclassic.blockconversion.state;

import java.util.List;
import java.util.Random;

import org.spongepowered.api.block.BlockState;


public class MultiStateAccess implements IBlockStateAccess {
	
	private List<BlockState> blockStates;
	private double[] probabilities; 
	private Random random = new Random();

	private MultiStateAccess(Builder builder) {
		blockStates = builder.getStates();
		probabilities=builder.getProbabilities();
	}


	@Override
	public BlockState getState() {
		int index = getBlockIndex();
		return blockStates.get(index);
	}
	
	
	private int getBlockIndex() {
		int index = 0;
		while(true) {
			double value = random.nextDouble();
			if(value < probabilities[index]) {
				return index;
			}
			if(index==probabilities.length-1) {
				index=0;
			}
			else {
				index++;
			}
		}
	}


	static class Builder {
		
		private List<BlockState> states;
		private double[] probabilities;
	
		public Builder setStates(List<BlockState> states)    { this.states = states; return this; }
		public Builder setProbabilities(double[] p ) 		{ this.probabilities=p; return this; }
		
		private List<BlockState> getStates() { return states; 		}	
		private double[] getProbabilities()  { return probabilities; 	}
	
		IBlockStateAccess build() {
			return new MultiStateAccess(this);
		}
	}

}
