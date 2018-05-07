package net.kevinmendoza.geology2minecraftclassic.configuration;

import java.util.ArrayList;
import java.util.List;

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
		// Basalt defaults
		List<BlockStateDefault> blockStateDefaults = new ArrayList<>();
		blockStateDefaults.add(new BlockStateDefault(
				new BlockStateAccessDefaults.Builder().build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetaDataDefaults.Builder().build()));
		//Andesite Defaults
		blockStateDefaults.add(new BlockStateDefault(
				new BlockStateAccessDefaults.Builder().build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetaDataDefaults.Builder().build()));
		// kimberlite defaults
		blockStateDefaults.add(new BlockStateDefault(
				new BlockStateAccessDefaults.Builder().build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetaDataDefaults.Builder().build()));
		// gabbro
		blockStateDefaults.add(new BlockStateDefault(
				new BlockStateAccessDefaults.Builder().build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetaDataDefaults.Builder().build()));
		// serpentine
		blockStateDefaults.add(new BlockStateDefault(
				new BlockStateAccessDefaults.Builder().build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetaDataDefaults.Builder().build()));

		return blockStateDefaults;
	}
	
	private List<BlockStateDefault> buildFelsicRocks() {
		// granite
		List<BlockStateDefault> blockStateDefaults = new ArrayList<>();
		blockStateDefaults.add(new BlockStateDefault(
				new BlockStateAccessDefaults.Builder().build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetaDataDefaults.Builder().build()));
		//diorite
		blockStateDefaults.add(new BlockStateDefault(
				new BlockStateAccessDefaults.Builder().build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetaDataDefaults.Builder().build()));
		// rhyolite
		blockStateDefaults.add(new BlockStateDefault(
				new BlockStateAccessDefaults.Builder().build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetaDataDefaults.Builder().build()));
		// gneiss
		blockStateDefaults.add(new BlockStateDefault(
				new BlockStateAccessDefaults.Builder().build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetaDataDefaults.Builder().build()));
		// Pegmatite
		blockStateDefaults.add(new BlockStateDefault(
				new BlockStateAccessDefaults.Builder().build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetaDataDefaults.Builder().build()));

		return blockStateDefaults;
	}

	private List<BlockStateDefault> buildSilicateRocks() {
		// Sandstone
		List<BlockStateDefault> blockStateDefaults = new ArrayList<>();
		blockStateDefaults.add(new BlockStateDefault(
				new BlockStateAccessDefaults.Builder().build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetaDataDefaults.Builder().build()));
		
		// quartzite
		blockStateDefaults.add(new BlockStateDefault(
				new BlockStateAccessDefaults.Builder().build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetaDataDefaults.Builder().build()));
		
		// conglomerate
		blockStateDefaults.add(new BlockStateDefault(
				new BlockStateAccessDefaults.Builder().build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetaDataDefaults.Builder().build()));
		return blockStateDefaults;
	}
	private List<BlockStateDefault> buildCarbonateRocks() {
		// TODO Auto-generated method stub
		return null;
	}
	private List<BlockStateDefault> buildClayRocks() {
		// TODO Auto-generated method stub
		return null;
	}
}
