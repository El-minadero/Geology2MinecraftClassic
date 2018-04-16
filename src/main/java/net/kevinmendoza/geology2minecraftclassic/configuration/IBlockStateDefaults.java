package net.kevinmendoza.geology2minecraftclassic.configuration;

import net.kevinmendoza.geology2minecraftclassic.blockconversion.IBlockMetadata;

public interface IBlockStateDefaults {

	IBlockStateAccessDefaults getAccessDefaults();

	IOreControlDefaults getOreControlDefaults();

	IMetaControlDefaults getMetaControlDefaults();

	IMetadataDefaults getMetadata();

}
