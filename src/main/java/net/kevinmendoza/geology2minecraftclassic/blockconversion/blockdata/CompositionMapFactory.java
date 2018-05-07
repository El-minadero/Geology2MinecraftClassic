package net.kevinmendoza.geology2minecraftclassic.blockconversion.blockdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.inject.Inject;

import net.kevinmendoza.geology2minecraftclassic.blockconversion.IBlockBase;
import net.kevinmendoza.geology2minecraftclassic.blockconversion.BlockFactory;
import net.kevinmendoza.geology2minecraftclassic.configuration.IBlockStateDefaults;
import net.kevinmendoza.geology2minecraftclassic.configuration.IGlobalDefaults;
import net.kevinmendoza.geoworldlibrary.geology.rockdata.BulkComposition;

public class CompositionMapFactory {

	@Inject
	IGlobalDefaults globalDefaults; 

	private BlockFactory stateFactory;
	
	public CompositionMapFactory() {
		stateFactory = new BlockFactory();
	}
	
	public BlockConverter createConverter() {
		List<IBlockStateDefaults> defaultList = globalDefaults.getBlockStateList();
		List<IBlockBase> blockBases = populateBlockList(defaultList);
		HashMap<String,IBlockBase> rockMap =populateMap(blockBases);
		
		rockMap = connectRocks(rockMap);
		HashMap<BulkComposition,List<IBlockBase>> partitionedBases = partitionBlocks(blockBases);
		HashMap<BulkComposition,CompositionStartingPositions> finalBlockMap = 
				createCompositionStartingMap(partitionedBases);
		
		return new BlockConverter(finalBlockMap);
	}
	
	private HashMap<BulkComposition, CompositionStartingPositions> createCompositionStartingMap(
			HashMap<BulkComposition, List<IBlockBase>> partitionedBases) {

		HashMap<BulkComposition,CompositionStartingPositions> finalMap  = new HashMap<>();

		for(BulkComposition composition : BulkComposition.values()) {

			List<IBlockBase> blocks = partitionedBases.get(composition);
			IBlockBase amorphous =null;
			IBlockBase fine=null;
			IBlockBase medium=null;
			IBlockBase coarse=null;

			for(IBlockBase block : blocks) {

				if(block.getMetadata().isStartingBlock()) {
					if(block.getMetadata().isAmorphous()) {
						amorphous = block;
					}
					else if(block.getMetadata().isFine()) {
						fine = block;
					}
					else if(block.getMetadata().isMedium()) {
						medium = block;
					}
					else {
						coarse = block;
					}
				}
			}
			finalMap.put(composition, new CompositionStartingPositions.Builder()
					.setAmorphous(amorphous)
					.setFine(fine)
					.setMedium(medium)
					.setCoarse(coarse)
					.Build());
			
		}
		return finalMap;
	}

	private HashMap<BulkComposition, List<IBlockBase>> partitionBlocks(List<IBlockBase> blockBases) {
		HashMap<BulkComposition,List<IBlockBase>> map = new HashMap<>();
		for(BulkComposition comp : BulkComposition.values()) {
			map.put(comp, new ArrayList<IBlockBase>());
		}
		for(IBlockBase base : blockBases) {
			map.get(base.getMetadata().getComposition()).add(base);
		}
		return map;
	}

	private HashMap<String, IBlockBase> connectRocks(HashMap<String,
			IBlockBase> rockMap) {
		for(IBlockBase base : rockMap.values()) {
			List<String> targetBases = base.getTargets();
			List<IBlockBase> baseTarget = new ArrayList<>();
			
			baseTarget.add(rockMap.get(targetBases.get(0)));
			baseTarget.add(rockMap.get(targetBases.get(1)));
			
			base.setTargets(baseTarget);
		}
		return rockMap;
	}

	private HashMap<String,IBlockBase> populateMap(List<IBlockBase> blockBases) {
		HashMap<String,IBlockBase> rockMap = new HashMap<>();
		for(IBlockBase base : blockBases) {
			rockMap.put(base.getMetadata().getName(), base);
		}
		return rockMap;
	}

	private List<IBlockBase> populateBlockList(List<IBlockStateDefaults> defaultList) {
		List<IBlockBase> blockBases = new ArrayList<>();
		for(IBlockStateDefaults defaults : defaultList) {
			blockBases.add(stateFactory.createState(defaults));
		}
		return blockBases;
	}
	
}
