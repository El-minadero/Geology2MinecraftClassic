package net.kevinmendoza.geology2minecraftclassic.configuration;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@ConfigSerializable
public class BlockStateDefault implements IBlockStateDefaults {
	
	@Setting
	private MetadataDefaults metaData;
	@Setting
	private BlockStateAccessDefaults blockStateAccessDefaults;
	@Setting
	private OreControlDefaults oreControlDefaults;
	@Setting
	private MetamorphicControlDefaults metamorphicControlDefaults;
	
	public BlockStateDefault(BlockStateAccessDefaults stateAccess, OreControlDefaults oreControl,
							MetamorphicControlDefaults metaControl, MetadataDefaults metadata) {
		blockStateAccessDefaults=stateAccess;
		oreControlDefaults=oreControl;
		metamorphicControlDefaults=metaControl;
		metaData=metadata;
	}

	@Override
	public IBlockStateAccessDefaults getAccessDefaults()		{ return blockStateAccessDefaults; }
	@Override
	public IOreControlDefaults getOreControlDefaults() 		{ return oreControlDefaults; }
	@Override
	public IMetaControlDefaults getMetaControlDefaults()		{ return metamorphicControlDefaults; }
	@Override
	public IMetadataDefaults getMetadata() 					{ return metaData; }

}
