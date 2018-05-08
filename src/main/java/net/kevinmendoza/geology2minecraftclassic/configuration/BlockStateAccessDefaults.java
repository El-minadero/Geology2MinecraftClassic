package net.kevinmendoza.geology2minecraftclassic.configuration;

import java.util.List;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@ConfigSerializable
public class BlockStateAccessDefaults implements IBlockStateAccessDefaults {

	@Setting
	private double[] probabilities;
	@Setting
	private List<String> variants;
	@Setting
	private List<String> types;
	
	
	public BlockStateAccessDefaults(Builder builder) {
		probabilities=builder.getProbabilities();
		variants     = builder.getVariants();
		types        = builder.getTypes();
	}

	public List<String> getTypes() { 	return types; }
	public boolean isSingleState() { 	return (types.size()==1); }
	public List<String> getVariants() { 	return variants; }
	public double[] getProbabilities() { return probabilities; }
	
	static class Builder {
		private double[] probabilities;
		private List<String> variants;
		private List<String> types;
		
		Builder() {
			probabilities = new double[1];
		}
		
		public List<String> getTypes() { return types; }
		public List<String> getVariants() { return variants; }
		public double[] getProbabilities() { return probabilities; }
		
		Builder setProbabilities(double[] probs) {
			this.probabilities = probs; return this;
		}
		Builder setVariants(List<String> variants) {
			this.variants = variants; return this;
		}
		Builder setTypes(List<String> types) {
			this.types=types; return this; 
		}
		
		BlockStateAccessDefaults build() {
			return new BlockStateAccessDefaults(this);
		}
	}
}
