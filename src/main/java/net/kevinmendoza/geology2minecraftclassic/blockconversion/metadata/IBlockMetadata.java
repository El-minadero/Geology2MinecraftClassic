package net.kevinmendoza.geology2minecraftclassic.blockconversion.metadata;

import net.kevinmendoza.geoworldlibrary.geology.rockdata.BulkComposition;

public interface IBlockMetadata {
	
	String getName();

	BulkComposition getComposition();

	boolean isStartingBlock();

	boolean isAmorphous();

	boolean isFine();

	boolean isMedium();

}
