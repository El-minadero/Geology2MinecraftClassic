package net.kevinmendoza.geology2minecraftclassic.blockconversion.state;

import java.util.HashMap;
import java.util.Optional;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.immutable.ImmutableDyeableData;
import org.spongepowered.api.data.manipulator.mutable.DyeableData;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.type.DyeColors;

class DataModifiersClay {

	
private DyeColor defaultDye = DyeColors.ORANGE;
	
	private HashMap<String, DyeColor> sandTypeMap;
	
	public DataModifiersClay() {
		sandTypeMap= new HashMap<>();
		populateMap();
	}
	private void populateMap() {
		sandTypeMap.put("DEFAULT", 	DyeColors.ORANGE);
		sandTypeMap.put("RED", 		DyeColors.RED);
		sandTypeMap.put("YELLOW", 	DyeColors.YELLOW);
		sandTypeMap.put("GREEN", 	DyeColors.GREEN);
		sandTypeMap.put("BLACK", 	DyeColors.BLACK);
		sandTypeMap.put("BLUE",     	DyeColors.BLUE);
		sandTypeMap.put("BROWN", 	DyeColors.BROWN);
		sandTypeMap.put("CYAN", 		DyeColors.CYAN);
		sandTypeMap.put("GREY", 		DyeColors.GRAY);
		sandTypeMap.put("LIGHT_BLUE",DyeColors.LIGHT_BLUE);
		sandTypeMap.put("LIME", 		DyeColors.LIME);
		sandTypeMap.put("MAGENTA", 	DyeColors.MAGENTA);
		sandTypeMap.put("PINK", 		DyeColors.PINK);
		sandTypeMap.put("PURPLE",	DyeColors.PURPLE);
		sandTypeMap.put("SILVER", 	DyeColors.SILVER);
		sandTypeMap.put("WHITE", 	DyeColors.WHITE);
	}
	
	private DyeColor getDyeType(String variant) {
		if(sandTypeMap.containsKey(variant)) {
			return sandTypeMap.get(variant);
		}
		else {
			return defaultDye;
		}
	}

	BlockState modifyClayState(BlockType blockType, String variant) {
		BlockState state = blockType.getDefaultState();
		Optional<ImmutableDyeableData> stateData = state.get(ImmutableDyeableData.class);
		DyeableData dyebleData = stateData.get().asMutable().set(Keys.DYE_COLOR,getDyeType(variant));
		return state.copy().with(dyebleData.asImmutable()).get();
	}
}
