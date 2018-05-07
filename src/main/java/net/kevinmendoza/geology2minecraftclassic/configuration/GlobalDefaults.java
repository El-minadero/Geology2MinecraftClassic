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
		blockStateList =new BlockConfigFactory().getRocks();
	}

	@Override
	public List<IBlockStateDefaults> getBlockStateList() {
		List<IBlockStateDefaults> interfaceList = new ArrayList<>();
		for(BlockStateDefault blockStateDefault : blockStateList) {
			interfaceList.add((IBlockStateDefaults)blockStateDefault);
		}
		return interfaceList;
	}
	
	
}
