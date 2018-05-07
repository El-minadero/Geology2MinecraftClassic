package net.kevinmendoza.geology2minecraftclassic.blockconversion.state;

import java.util.HashMap;
import java.util.Optional;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.immutable.block.ImmutableSandData;
import org.spongepowered.api.data.manipulator.mutable.block.SandData;
import org.spongepowered.api.data.type.SandType;
import org.spongepowered.api.data.type.SandTypes;

class DataModifierSand {
	
	private SandType defaultSand = SandTypes.NORMAL;
	
	private HashMap<String, SandType> sandTypeMap;
	
	public DataModifierSand() {
		sandTypeMap= new HashMap<>();
		populateMap();
	}
	private void populateMap() {
		sandTypeMap.put("DEFAULT", SandTypes.NORMAL);
		sandTypeMap.put("RED", SandTypes.RED);
	}
	
	private SandType getSandType(String variant) {
		if(sandTypeMap.containsKey(variant)) {
			return sandTypeMap.get(variant);
		}
		else {
			return defaultSand;
		}
	}

	BlockState modifySandState(BlockType blockType, String variant) {
		BlockState state = blockType.getDefaultState();
		Optional<ImmutableSandData> stateData = state.get(ImmutableSandData.class);
		SandData sandData = stateData.get().asMutable().set(Keys.SAND_TYPE,getSandType(variant));
		return state.copy().with(sandData.asImmutable()).get();
	}
}
