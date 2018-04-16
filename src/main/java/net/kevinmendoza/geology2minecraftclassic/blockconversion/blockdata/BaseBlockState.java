package net.kevinmendoza.geology2minecraftclassic.blockconversion.blockdata;

import java.util.List;

import org.spongepowered.api.block.BlockState;

import net.kevinmendoza.geology2minecraftclassic.blockconversion.IBlockBase;
import net.kevinmendoza.geology2minecraftclassic.blockconversion.IBlockMetadata;
import net.kevinmendoza.geology2minecraftclassic.blockconversion.metamorphic.IMetaControl;
import net.kevinmendoza.geology2minecraftclassic.blockconversion.ore.IOreControl;
import net.kevinmendoza.geology2minecraftclassic.blockconversion.state.IBlockStateAccess;
import net.kevinmendoza.geoworldlibrary.geology.rockdata.IRetrieveData;

public class BaseBlockState implements IBlockBase {

	private IMetaControl metamorphicControl;
	private IOreControl oreControl;
	private IBlockStateAccess stateAccess;
	private IBlockMetadata metadata;
	
	private BaseBlockState(Builder builder) {
		metamorphicControl 	= builder.getMetamorphicControl();
		oreControl 			= builder.getOreControl();
		stateAccess    		= builder.getStateAccess();
		metadata			= builder.getMetadata();
	}

	public IBlockMetadata getMetadata() { return metadata; }

	public void setTargets(List<IBlockBase> blockList) { 
		metamorphicControl.setTargets(blockList);
	}

	public List<String> getTargets() { return metamorphicControl.getTargets(); }

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
		BlockState state = this.stateAccess.getState();
		if(oreControl.isOre(retrievalData)) {
			state= oreControl.getOre(retrievalData);
		}
		return state;
	}


	public static class Builder {

		private IMetaControl metamorphicControl;
		private IOreControl oreControl;
		private IBlockStateAccess state;
		private IBlockMetadata metadata;
		
		public IMetaControl getMetamorphicControl() { return metamorphicControl;}
		public IBlockMetadata getMetadata() { return metadata; }

		public IBlockStateAccess getStateAccess() { return state; }
		public IOreControl getOreControl() { return oreControl; }
		
		public Builder setMetadata(IBlockMetadata data) {
			this.metadata = data; return this;
		}
		
		public Builder setMetaControl(IMetaControl control) {
			metamorphicControl=control;	return this;
		}
		public Builder setOreControl(IOreControl control) {
			oreControl=control;	return this;
		}
		public Builder setState(IBlockStateAccess state) {
			this.state=state;	return this;
		}
		
		public IBlockBase Build() {
			return new BaseBlockState(this);
		}
	}

}
