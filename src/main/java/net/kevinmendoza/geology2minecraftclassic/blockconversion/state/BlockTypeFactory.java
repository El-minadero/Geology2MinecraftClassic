package net.kevinmendoza.geology2minecraftclassic.blockconversion.state;

import java.util.HashMap;

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;

class BlockTypeFactory {

	private HashMap<String,BlockType> blockMap;
	
	BlockTypeFactory() {
		blockMap = new HashMap<>();
		populateMap();
	}
	
	private void populateMap() {
		blockMap.put("STONE", 	BlockTypes.STONE);
		blockMap.put("GRAVEL", 	BlockTypes.GRAVEL);
		blockMap.put("SAND",  	BlockTypes.SAND);
		blockMap.put("DIRT",  	BlockTypes.DIRT);
		blockMap.put("SANDSTONE",  		BlockTypes.SANDSTONE);
		blockMap.put("CLAY",  			BlockTypes.CLAY);
		blockMap.put("COBBLESTONE",  	BlockTypes.COBBLESTONE);
		blockMap.put("OBSIDIAN",  		BlockTypes.OBSIDIAN);
		blockMap.put("LITHIFIED_CLAY",  	BlockTypes.STAINED_HARDENED_CLAY);
	}

	public BlockType getType(String type) {
		if(blockMap.containsKey(type)) {
			return blockMap.get(type);
		}
		return blockMap.get("STONE");
	}
}
