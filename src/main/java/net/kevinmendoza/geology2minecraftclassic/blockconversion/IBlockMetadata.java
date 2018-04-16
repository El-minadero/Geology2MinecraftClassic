package net.kevinmendoza.geology2minecraftclassic.blockconversion;

import net.kevinmendoza.geoworldlibrary.geology.rockdata.BulkComposition;

public interface IBlockMetadata {
	IBlockMetadata getMetadata();
	
	String getName();

	BulkComposition getComposition();

	boolean isStartingBlock();

	boolean isAmorphous();

	boolean isFine();

	boolean isMedium();

}
