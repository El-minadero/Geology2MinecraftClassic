package net.kevinmendoza.geology2minecraftclassic.configuration;

import java.util.ArrayList;
import java.util.List;

import org.spongepowered.api.block.BlockTypes;

import net.kevinmendoza.geoworldlibrary.geology.rockdata.BulkComposition;

class BlockConfigFactory {

	public List<BlockStateDefault> getRocks() {
		List<BlockStateDefault> blockStateDefaults = new ArrayList<>();
		blockStateDefaults.addAll(buildMaficRocks());
		blockStateDefaults.addAll(buildFelsicRocks());
		blockStateDefaults.addAll(buildSilicateRocks());
		blockStateDefaults.addAll(buildCarbonateRocks());
		blockStateDefaults.addAll(buildClayRocks());
		return blockStateDefaults;
	}

	private List<BlockStateDefault> buildMaficRocks() {
		List<BlockStateDefault> blockStateDefaults = new ArrayList<>();
		/*
		 * First, the primary rocks
		 */
		blockStateDefaults.add(makeBasalt());
		blockStateDefaults.add(makeAndesite());
		blockStateDefaults.add(makeKimberlite());
		blockStateDefaults.add(makeGabbro());
		return blockStateDefaults;
	}

	private List<BlockStateDefault> buildFelsicRocks() {
		List<BlockStateDefault> blockStateDefaults = new ArrayList<>();
		/*
		 * First, the primary rocks
		 */
		blockStateDefaults.add(makeGranite());
		blockStateDefaults.add(makeDiorite());
		blockStateDefaults.add(makeRhyolite());
		blockStateDefaults.add(makeObsidian());
		return blockStateDefaults;
	}

	private List<BlockStateDefault> buildSilicateRocks() {
		List<BlockStateDefault> blockStateDefaults = new ArrayList<>();
		/*
		 * First, the primary rocks
		 */
		blockStateDefaults.add(makeSandStone());
		blockStateDefaults.add(makeConglomerate());
		return blockStateDefaults;
	}

	private List<BlockStateDefault> buildCarbonateRocks() {
		List<BlockStateDefault> blockStateDefaults = new ArrayList<>();
		/*
		 * First, the primary rocks
		 */
		blockStateDefaults.add(makeLimestone());
		blockStateDefaults.add(makeCarbonatite());
		return blockStateDefaults;
	}

	private List<BlockStateDefault> buildClayRocks() {
		List<BlockStateDefault> blockStateDefaults = new ArrayList<>();
		/*
		 * First, the primary rocks
		 */
		blockStateDefaults.add(makeMudstone());
		return blockStateDefaults;
	}
	
	private BlockStateDefault makeBasalt() {
		double[] basaltProbs = {0.5,0.5};
		List<String> basaltTypes = new ArrayList<>();
		List<String> variants = new ArrayList<>();
		basaltTypes.add("STONE");
		basaltTypes.add("LITHIFIED_CLAY");
		variants.add("ANDESITE");
		variants.add("BLACK");
		
		String texture="fine";
		String name = "basalt";
		String composition = "mafic";
		boolean isStartingPosition = true;
		
		
		return new BlockStateDefault(
				new BlockStateAccessDefaults.Builder()
								.setProbabilities(basaltProbs)
								.setTypes(basaltTypes)
								.setVariants(variants)
								.build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetadataDefaults.Builder()
				.setName(name)
				.setTexture(texture)
				.setComposition(composition)
				.setStart(isStartingPosition)
				.build());
	}
	
	private BlockStateDefault makeAndesite() {
		double[] basaltProbs = {1.0};
		List<String> basaltTypes = new ArrayList<>();
		List<String> variants = new ArrayList<>();
		basaltTypes.add("STONE");
		variants.add("ANDESITE");
		
		String texture="fine";
		String name = "andesite";
		String composition = "mafic";
		boolean isStartingPosition = true;
		
		
		return new BlockStateDefault(
				new BlockStateAccessDefaults.Builder()
								.setProbabilities(basaltProbs)
								.setTypes(basaltTypes)
								.setVariants(variants)
								.build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetadataDefaults.Builder()
				.setName(name)
				.setTexture(texture)
				.setComposition(composition)
				.setStart(isStartingPosition)
				.build());
	}
	
	private BlockStateDefault makeKimberlite() {
		double[] basaltProbs = {0.7,0.2,0.2};
		List<String> basaltTypes = new ArrayList<>();
		List<String> variants = new ArrayList<>();
		basaltTypes.add("STONE");
		basaltTypes.add("STONE");
		basaltTypes.add("LITHIFIED_CLAY");
		variants.add("ANDESITE");
		variants.add("STONE");
		variants.add("BLACK");
		
		String texture="amorphous";
		String name = "kimberlite";
		String composition = "mafic";
		boolean isStartingPosition = true;
		
		
		return new BlockStateDefault(
				new BlockStateAccessDefaults.Builder()
								.setProbabilities(basaltProbs)
								.setTypes(basaltTypes)
								.setVariants(variants)
								.build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetadataDefaults.Builder()
				.setName(name)
				.setTexture(texture)
				.setComposition(composition)
				.setStart(isStartingPosition)
				.build());
	}
	
	private BlockStateDefault makeGabbro() {
		double[] basaltProbs = {0.7,0.3};
		List<String> basaltTypes = new ArrayList<>();
		List<String> variants = new ArrayList<>();
		basaltTypes.add("STONE");
		basaltTypes.add("STONE");
		variants.add("ANDESITE");
		variants.add("DIORITE");
		
		String texture="Coarse";
		String name = "Gabbro";
		String composition = "mafic";
		boolean isStartingPosition = true;
		
		
		return new BlockStateDefault(
				new BlockStateAccessDefaults.Builder()
								.setProbabilities(basaltProbs)
								.setTypes(basaltTypes)
								.setVariants(variants)
								.build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetadataDefaults.Builder()
				.setName(name)
				.setTexture(texture)
				.setComposition(composition)
				.setStart(isStartingPosition)
				.build());
	}
	
	private BlockStateDefault makeGranite() {
		double[] basaltProbs = {0.7,0.3};
		List<String> basaltTypes = new ArrayList<>();
		List<String> variants = new ArrayList<>();
		basaltTypes.add("STONE");
		variants.add("GRANITE");
		
		String texture="Coarse";
		String name = "Granite";
		String composition = "felsic";
		boolean isStartingPosition = true;
		
		
		return new BlockStateDefault(
				new BlockStateAccessDefaults.Builder()
								.setProbabilities(basaltProbs)
								.setTypes(basaltTypes)
								.setVariants(variants)
								.build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetadataDefaults.Builder()
				.setName(name)
				.setTexture(texture)
				.setComposition(composition)
				.setStart(isStartingPosition)
				.build());
	}
	
	private BlockStateDefault makeDiorite() {
		double[] basaltProbs = {0.7,0.3};
		List<String> basaltTypes = new ArrayList<>();
		List<String> variants = new ArrayList<>();
		basaltTypes.add("STONE");
		variants.add("DIORITE");
		
		String texture="Medium";
		String name = "Diorite";
		String composition = "felsic";
		boolean isStartingPosition = true;
		
		
		return new BlockStateDefault(
				new BlockStateAccessDefaults.Builder()
								.setProbabilities(basaltProbs)
								.setTypes(basaltTypes)
								.setVariants(variants)
								.build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetadataDefaults.Builder()
				.setName(name)
				.setTexture(texture)
				.setComposition(composition)
				.setStart(isStartingPosition)
				.build());
	}
	
	private BlockStateDefault makeRhyolite() {
		double[] basaltProbs = {0.7,0.3};
		List<String> basaltTypes = new ArrayList<>();
		List<String> variants = new ArrayList<>();
		basaltTypes.add("LITHIFIED_CLAY");
		variants.add("PINK");
		
		String texture="Fine";
		String name = "Rhyolite";
		String composition = "felsic";
		boolean isStartingPosition = true;
		
		
		return new BlockStateDefault(
				new BlockStateAccessDefaults.Builder()
								.setProbabilities(basaltProbs)
								.setTypes(basaltTypes)
								.setVariants(variants)
								.build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetadataDefaults.Builder()
				.setName(name)
				.setTexture(texture)
				.setComposition(composition)
				.setStart(isStartingPosition)
				.build());
	}
	
	private BlockStateDefault makeObsidian() {
	
		double[] basaltProbs = {0.2,0.8};
		List<String> basaltTypes = new ArrayList<>();
		List<String> variants = new ArrayList<>();
		basaltTypes.add("OBSIDIAN");
		basaltTypes.add("STONE");
		variants.add("DEFAULT");
		variants.add("ANDESITE");
		
		String texture="amorphous";
		String name = "Obsidian";
		String composition = "felsic";
		boolean isStartingPosition = true;
		
		
		return new BlockStateDefault(
				new BlockStateAccessDefaults.Builder()
								.setProbabilities(basaltProbs)
								.setTypes(basaltTypes)
								.setVariants(variants)
								.build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetadataDefaults.Builder()
				.setName(name)
				.setTexture(texture)
				.setComposition(composition)
				.setStart(isStartingPosition)
				.build());
	}
	
	private BlockStateDefault makeSandStone() {
		double[] basaltProbs = {0.2,0.8};
		List<String> basaltTypes = new ArrayList<>();
		List<String> variants = new ArrayList<>();
		basaltTypes.add("SANDSTONE");
		variants.add("DEFAULT");
		
		String name = "Sandstone";
		String composition = "silicate";
		boolean isStartingPosition = true;
		String texture = "fine";
		
		return new BlockStateDefault(
				new BlockStateAccessDefaults.Builder()
								.setProbabilities(basaltProbs)
								.setTypes(basaltTypes)
								.setVariants(variants)
								.build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetadataDefaults.Builder()
				.setName(name)
				.setTexture(texture)
				.setComposition(composition)
				.setStart(isStartingPosition)
				.build());
	}
	
	private BlockStateDefault makeConglomerate() {
		double[] basaltProbs = {0.2,0.8};
		List<String> basaltTypes = new ArrayList<>();
		List<String> variants = new ArrayList<>();
		basaltTypes.add("COBBLESTONE");
		variants.add("DEFAULT");
		
		String name = "Conglomerate";
		String composition = "silicate";
		String texture   = "coarse";
		boolean isStartingPosition = true;
		
		
		return new BlockStateDefault(
				new BlockStateAccessDefaults.Builder()
								.setProbabilities(basaltProbs)
								.setTypes(basaltTypes)
								.setVariants(variants)
								.build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetadataDefaults.Builder()
				.setName(name)
				.setTexture(texture)
				.setComposition(composition)
				.setStart(isStartingPosition)
				.build());
	}
	
	private BlockStateDefault makeLimestone() {
		double[] basaltProbs = {0.7,0.3};
		List<String> basaltTypes = new ArrayList<>();
		List<String> variants = new ArrayList<>();
		basaltTypes.add("LITHIFIED_CLAY");
		basaltTypes.add("SANDSTONE");
		variants.add("GREY");
		variants.add("DEFAULT");
		
		String texture="Fine";
		String name = "Limestone";
		String composition = "carbonate";
		boolean isStartingPosition = true;
		
		return new BlockStateDefault(
				new BlockStateAccessDefaults.Builder()
								.setProbabilities(basaltProbs)
								.setTypes(basaltTypes)
								.setVariants(variants)
								.build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetadataDefaults.Builder()
				.setName(name)
				.setTexture(texture)
				.setComposition(composition)
				.setStart(isStartingPosition)
				.build());
	}
	
	private BlockStateDefault makeCarbonatite() {
		double[] basaltProbs = {0.4,0.3,0.2};
		List<String> basaltTypes = new ArrayList<>();
		List<String> variants = new ArrayList<>();
		basaltTypes.add("LITHIFIED_CLAY");
		basaltTypes.add("STONE");
		basaltTypes.add("STONE");
		variants.add("GREY");
		variants.add("DIORITE");
		variants.add("DEFAULT");
		
		String texture="Fine";
		String name = "Carbonatite";
		String composition = "carbonate";
		boolean isStartingPosition = true;
		
		return new BlockStateDefault(
				new BlockStateAccessDefaults.Builder()
								.setProbabilities(basaltProbs)
								.setTypes(basaltTypes)
								.setVariants(variants)
								.build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetadataDefaults.Builder()
				.setName(name)
				.setTexture(texture)
				.setComposition(composition)
				.setStart(isStartingPosition)
				.build());
	}
	
	private BlockStateDefault makeMudstone() {
		double[] basaltProbs = {0.4,0.3,0.2};
		List<String> basaltTypes = new ArrayList<>();
		List<String> variants = new ArrayList<>();
		basaltTypes.add("LITHIFIED_CLAY");
		variants.add("BROWN");
		
		String texture="Fine";
		String name = "Mudstone";
		String composition = "Clay";
		boolean isStartingPosition = true;
		
		return new BlockStateDefault(
				new BlockStateAccessDefaults.Builder()
								.setProbabilities(basaltProbs)
								.setTypes(basaltTypes)
								.setVariants(variants)
								.build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetadataDefaults.Builder()
				.setName(name)
				.setTexture(texture)
				.setComposition(composition)
				.setStart(isStartingPosition)
				.build());
	}
}
