package net.kevinmendoza.geology2minecraftclassic.blockconversion;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.spongepowered.api.block.BlockState;

import net.kevinmendoza.geoworldlibrary.geology.rockdata.ActivityModifiers;
import net.kevinmendoza.geoworldlibrary.geology.rockdata.IRetrieveData;

class CompositionState implements IBlockBase {

	private MetamorphicControl metamorphicControl;
	private OreControl oreControl;
	private BlockState state;
	
	private CompositionState(Builder builder) {
		metamorphicControl 	= builder.getMetamorphicControl();
		oreControl 			= builder.getOreControl();
		state    			= builder.getState();
	}
	
	public final BlockState getBlockState(IRetrieveData retrievalData) {
		if(metamorphicControl.shouldConvert(retrievalData)) {
			return metamorphicControl.returnConvertedNodeBlockState(retrievalData);
		}
		else {
			return prepareBlockState(retrievalData);
		}
	}

	@Override
	public void setSeed(long seed) {
		metamorphicControl.setSeed(seed);	
		oreControl.setSeed(seed);
	}

	
	private BlockState prepareBlockState(IRetrieveData retrievalData) {
		BlockState state = this.state;
		if(oreControl.isOre(retrievalData)) {
			state= oreControl.getOre(retrievalData);
		}
		return state;
	}


	public static class Builder {

		private MetamorphicControl metamorphicControl;
		private OreControl oreControl;
		private BlockState state;
		
		public MetamorphicControl getMetamorphicControl() { return metamorphicControl;}
		public BlockState getState() { return state; }
		public OreControl getOreControl() { return oreControl; }
		
		public Builder setMetaControl(MetamorphicControl control) {
			metamorphicControl=control;	return this;
		}
		public Builder setOreControl(OreControl control) {
			oreControl=control;	return this;
		}
		public Builder setState(BlockState state) {
			this.state=state;	return this;
		}
		
		public IBlockBase Build() {
			return new CompositionState(this);
		}
	}

}
