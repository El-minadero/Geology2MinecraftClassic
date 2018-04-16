package net.kevinmendoza.geology2minecraftclassic.blockconversion.state;

import java.util.HashMap;

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;

class BlockTypeFactory {

	private HashMap<String,BlockType> blockMap;
	
	BlockTypeFactory() {
		blockMap = new HashMap<>();
		blockMap.put("STONE", BlockTypes.STONE);
		blockMap.put("GRAVEL",  BlockTypes.GRAVEL);
		blockMap.put("SAND",  BlockTypes.SAND);
		blockMap.put("DIRT",  BlockTypes.DIRT);
		blockMap.put("SANDSTONE",  BlockTypes.SANDSTONE);
		blockMap.put("RED_SANDSTONE",  BlockTypes.RED_SANDSTONE);
		blockMap.put("CLAY",  BlockTypes.CLAY);
		blockMap.put("HARDENED_CLAY",  BlockTypes.HARDENED_CLAY);
		blockMap.put("STAINED_HARDENED_CLAY", BlockTypes.STAINED_HARDENED_CLAY);
	
	}
}
