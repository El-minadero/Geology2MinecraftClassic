package net.kevinmendoza.geology2minecraftclassic.configuration;

import net.kevinmendoza.geoworldlibrary.geology.rockdata.BulkComposition;

public interface IMetadataDefaults {

	String getTexture();

	BulkComposition getComposition();

	String getName();

	boolean isStartingMember();

}
