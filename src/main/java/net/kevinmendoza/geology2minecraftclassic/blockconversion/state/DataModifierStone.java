package net.kevinmendoza.geology2minecraftclassic.blockconversion.state;

import java.util.HashMap;
import java.util.Optional;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.immutable.block.ImmutableStoneData;
import org.spongepowered.api.data.manipulator.mutable.block.StoneData;
import org.spongepowered.api.data.type.StoneType;
import org.spongepowered.api.data.type.StoneTypes;

class DataModifierStone {
	
	private StoneType defaultStone = StoneTypes.STONE;

	private HashMap<String, StoneType> stoneTypeMap;
	
	public DataModifierStone() {
		stoneTypeMap= new HashMap<>();
		populateMap();
	}
	private void populateMap() {
		stoneTypeMap.put("DEFAULT", StoneTypes.STONE);
		stoneTypeMap.put("GRANITE", StoneTypes.GRANITE);
		stoneTypeMap.put("ANDESITE", StoneTypes.ANDESITE);
		stoneTypeMap.put("DIORITE", StoneTypes.DIORITE);
	}
	
	private StoneType getStoneType(String variant) {
		if(stoneTypeMap.containsKey(variant)) {
			return stoneTypeMap.get(variant);
		}
		else {
			return defaultStone;
		}
	}
	
	BlockState modifyStoneState(BlockType type, String variant) {
		BlockState stone = type.getDefaultState();
		Immu
		Optional<ImmutableStoneData> stoneStateData =stone.get(ImmutableStoneData.class);
		StoneData granite = stoneStateData.get().asMutable().set(Keys.STONE_TYPE,getStoneType(variant));
		return stone.copy().with(granite.asImmutable()).get();
	}
}
