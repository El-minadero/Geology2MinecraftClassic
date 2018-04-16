package net.kevinmendoza.geology2minecraftclassic.blockconversion.blockdata;

import java.util.List;

import org.spongepowered.api.block.BlockState;

import net.kevinmendoza.geology2minecraftclassic.blockconversion.IBlockBase;
import net.kevinmendoza.geoworldlibrary.geology.rockdata.IRetrieveData;
import net.kevinmendoza.geoworldlibrary.geology.rockdata.Texture;

class CompositionStartingPositions {
	
	private IBlockBase startingAmorphous;
	private IBlockBase startingFine;
	private IBlockBase startingMedium;
	private IBlockBase startingCoarse;
	
	
	private CompositionStartingPositions(Builder builder) {
		startingAmorphous	= builder.getAmorphous();
		startingFine		= builder.getFine();
		startingMedium		= builder.getMedium();
		startingCoarse		= builder.getCoarse();
	}

	public BlockState getBlockState(IRetrieveData retrievalData) {
		Texture texture = retrievalData.getTexture();
		if(texture==Texture.Amorphous) {
			return startingAmorphous.getBlockState(retrievalData);
		}
		else if(texture==Texture.Fine) {
			return startingFine.getBlockState(retrievalData);
		}
		else if(texture==Texture.Medium) {
			return startingMedium.getBlockState(retrievalData);
		}
		else
			return startingCoarse.getBlockState(retrievalData);
	}

	public static class Builder {
		
		private IBlockBase startingAmorphous;
		private IBlockBase startingFine;
		private IBlockBase startingMedium;
		private IBlockBase startingCoarse;
		
		public IBlockBase getAmorphous() { return startingAmorphous; }
		public IBlockBase getCoarse()	 { return startingCoarse; }
		public IBlockBase getMedium() 	{ return startingMedium; }
		public IBlockBase getFine() 	{ return startingFine; }
		
		public Builder setAmorphous(IBlockBase base) {
			this.startingAmorphous=base; return this;
		}
		public Builder setFine(IBlockBase base) {
			this.startingFine=base; return this;
		}
		public Builder setMedium(IBlockBase base) {
			this.startingMedium=base; return this;
		}
		public Builder setCoarse(IBlockBase base) {
			this.startingCoarse=base; return this;
		}
		
		public CompositionStartingPositions Build() {
			return new CompositionStartingPositions(this);
		}
		
	}
	
}
