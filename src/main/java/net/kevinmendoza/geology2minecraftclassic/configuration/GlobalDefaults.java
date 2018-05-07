package net.kevinmendoza.geology2minecraftclassic.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.spongepowered.api.block.BlockState;

import com.google.common.reflect.TypeToken;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@ConfigSerializable
public class GlobalDefaults implements IGlobalDefaults {
	public static final TypeToken<GlobalDefaults> type = TypeToken.of(GlobalDefaults.class);
	
	@Setting
	private List<BlockStateDefault> blockStateList;
	
	public GlobalDefaults() {
		blockStateList = buildDefaultList();
	}

	@Override
	public List<IBlockStateDefaults> getBlockStateList() {
		List<IBlockStateDefaults> interfaceList = new ArrayList<>();
		for(BlockStateDefault blockStateDefault : blockStateList) {
			interfaceList.add((IBlockStateDefaults)blockStateDefault);
		}
		return interfaceList;
	}
	
	private List<BlockStateDefault> buildDefaultList() {
		List<BlockStateDefault> blockStateDefaults = new ArrayList<>();
		blockStateDefaults.addAll(buildMaficRocks());
		blockStateDefaults.addAll(buildFelsicRocks());
		blockStateDefaults.addAll(buildSilicateRocks());
		blockStateDefaults.addAll(buildCarbonateRocks());
		blockStateDefaults.addAll(buildClayRocks());
		return blockStateDefaults;
	}

	private List<BlockStateDefault> buildMaficRocks() {
		/*
		 * Lets try building 
		 * basalt. andesite, kimberlite
		 */
		List<BlockStateDefault> blockStateDefaults = new ArrayList<>();
		blockStateDefaults.add(new BlockStateDefault(
				new BlockStateAccessDefaults.Builder().build(), 
				new OreControlDefaults.Builder().build(), 
				new MetamorphicControlDefaults.Builder().build(), 
				new MetaDataDefaults.Builder().build()));
		return null;
	}
	
	private List<BlockStateDefault> buildFelsicRocks() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<BlockStateDefault> buildSilicateRocks() {
		// TODO Auto-generated method stub
		return null;
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
