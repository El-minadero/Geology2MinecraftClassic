package net.kevinmendoza.geology2minecraftclassic.blockconversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.spongepowered.api.block.BlockState;

import net.kevinmendoza.geoworldlibrary.geology.rockdata.ActivityModifiers;
import net.kevinmendoza.geoworldlibrary.geology.rockdata.IRetrieveData;

class MetamorphicControl {

	private double[] beginMetamorphosism;
	private double[] endMetamorphosism;
	private List<IBlockBase> conversionTargets;
	private Random random;
	private final List<ActivityModifiers> metamorphicControls = 
			Collections.unmodifiableList(
			Arrays.asList(ActivityModifiers.Pressure,ActivityModifiers.Temperature));
	
	private MetamorphicControl(Builder builder) {
		beginMetamorphosism=builder.getBeginningLevel();
		endMetamorphosism=builder.getEndLevel();
		conversionTargets=builder.getConversionTargets();
		random = new Random();
	}
	
	void setSeed(long seed) {
		random = new Random(seed);
	}
	public boolean shouldConvert(IRetrieveData retrievalData) {
		if(conversionTargets.size()==0)
			return false;
		else {
			return (exceedsThreshold(0,retrievalData) || exceedsThreshold(1,retrievalData));
		}
	}

	private boolean exceedsThreshold(int i,IRetrieveData retrievalData) {
		double value   = retrievalData.getModifierValue(metamorphicControls.get(i));
		if(value < beginMetamorphosism[i])
			return false;
		else if(value > endMetamorphosism[i])
			return true;
		else {
			double begin=beginMetamorphosism[i];
			double end=endMetamorphosism[i];
			return decideMetamorphosism(begin,end,value);
		}
	}


	private boolean decideMetamorphosism(double begin, double end, double value) {
		double adjustedValue = value - begin;
		double adjustedPercent = adjustedValue/(end-begin);
		double tryIt = random.nextDouble();
		return (tryIt > adjustedPercent);
	}

	public BlockState returnConvertedNodeBlockState(IRetrieveData retrievalData) {
		IBlockBase base=null;
		while(base==null) {
			if(exceedsThreshold(0,retrievalData))
				base=conversionTargets.get(0);
			else if(exceedsThreshold(1,retrievalData)) {
				base=conversionTargets.get(1);
			}
		}
		return base.getBlockState(retrievalData);
	}
	
	public static class Builder{

		private double[] beginningLevels;
		private double[] endingLevels;
		List<IBlockBase> conversionTargets=new ArrayList<>();
		
		public Builder setBeginningLevels(double[] levels) {
			this.beginningLevels=levels; return this;
		}
		public Builder setEndingLevels(double[] levels) {
			this.endingLevels=levels; return this;
		}
		public Builder setConversionTargetsLevels(List<IBlockBase> base) {
			this.conversionTargets=base; return this;
		}
		
		public double[] getBeginningLevel() {return beginningLevels; }
		public List<IBlockBase> getConversionTargets() { return conversionTargets;}
		public double[] getEndLevel() { return endingLevels; }
		
		public MetamorphicControl Build() {
			return new MetamorphicControl(this);
		}
	}
	
	
}
