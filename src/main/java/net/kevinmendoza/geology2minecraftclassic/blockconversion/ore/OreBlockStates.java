package net.kevinmendoza.geology2minecraftclassic.blockconversion.ore;

import java.util.HashMap;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockTypes;

class OreBlockStates {

	private HashMap<String, BlockState> oreBlockStates;

	public OreBlockStates() {
		oreBlockStates = new HashMap<String,BlockState>();
		populateBlockStates();
	}

	private void populateBlockStates() {
		oreBlockStates.put("GOLD", BlockTypes.GOLD_ORE.getDefaultState());
		oreBlockStates.put("IRON", BlockTypes.IRON_ORE.getDefaultState());
		oreBlockStates.put("COAL", BlockTypes.COAL_ORE.getDefaultState());
		oreBlockStates.put("REDSTONE", BlockTypes.REDSTONE_ORE.getDefaultState());
		oreBlockStates.put("LAPIS", BlockTypes.LAPIS_ORE.getDefaultState());
		oreBlockStates.put("EMERALD", BlockTypes.EMERALD_ORE.getDefaultState());
		oreBlockStates.put("DIAMOND", BlockTypes.DIAMOND_ORE.getDefaultState());
	}
}
