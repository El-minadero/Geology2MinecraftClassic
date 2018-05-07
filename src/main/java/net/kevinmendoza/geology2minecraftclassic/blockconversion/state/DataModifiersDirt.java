package net.kevinmendoza.geology2minecraftclassic.blockconversion.state;

import java.util.HashMap;
import java.util.Optional;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.immutable.block.ImmutableDirtData;
import org.spongepowered.api.data.manipulator.immutable.block.ImmutableStoneData;
import org.spongepowered.api.data.manipulator.mutable.block.DirtData;
import org.spongepowered.api.data.manipulator.mutable.block.StoneData;
import org.spongepowered.api.data.type.DirtType;
import org.spongepowered.api.data.type.DirtTypes;
import org.spongepowered.api.data.type.StoneType;
import org.spongepowered.api.data.type.StoneTypes;

class DataModifiersDirt {

	private DirtType defaultDirt = DirtTypes.DIRT;
	
	private HashMap<String, DirtType> dirtTypeMap;
	
	public DataModifiersDirt() {
		dirtTypeMap= new HashMap<>();
		populateMap();
	}
	private void populateMap() {
		dirtTypeMap.put("COARSE", DirtTypes.COARSE_DIRT);
		dirtTypeMap.put("DEFAULT", DirtTypes.DIRT);
		dirtTypeMap.put("PODZOL", DirtTypes.PODZOL);
	}
	
	private DirtType getDirtType(String variant) {
		if(dirtTypeMap.containsKey(variant)) {
			return dirtTypeMap.get(variant);
		}
		else {
			return defaultDirt;
		}
	}
	
	BlockState modifyDirtState(BlockType type, String variant) {
		BlockState stone = type.getDefaultState();
		Optional<ImmutableDirtData> dirtStateData =stone.get(ImmutableDirtData.class);
		DirtData dirtData = dirtStateData.get().asMutable().set(Keys.DIRT_TYPE,getDirtType(variant));
		return stone.copy().with(dirtData.asImmutable()).get();
	}

}
