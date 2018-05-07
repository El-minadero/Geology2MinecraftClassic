package net.kevinmendoza.geology2minecraftclassic.configuration;

public interface IBlockStateDefaults {

	IBlockStateAccessDefaults getAccessDefaults();

	IOreControlDefaults getOreControlDefaults();

	IMetaControlDefaults getMetaControlDefaults();

	IMetadataDefaults getMetadata();

}
