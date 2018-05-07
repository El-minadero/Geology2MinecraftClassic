package net.kevinmendoza.geology2minecraftclassic.configuration;

import java.util.List;

public interface IBlockStateAccessDefaults {

	List<String> getTypes();

	boolean isSingleState();

	List<String> getVariants();

	double[] getProbabilities();

}
