package net.kevinmendoza.geology2minecraftclassic.blockconversion.metamorphic;

import java.util.List;

import net.kevinmendoza.geology2minecraftclassic.configuration.IBlockStateDefaults;
import net.kevinmendoza.geology2minecraftclassic.configuration.IMetaControlDefaults;

public class MetamorphicControlFactory implements IMetaControlFactory {


	public IMetaControl createMetamorphicControl(IBlockStateDefaults defaults) {
		IMetaControlDefaults metaControlDefaults = defaults.getMetaControlDefaults();
		double[] beginningLevels = metaControlDefaults.getBeginningLevels();
		double[] endingLevels	 = metaControlDefaults.getEndingLevels();
		List<String> conversionTargets = metaControlDefaults.getConversionTargets();
		return new MetamorphicControl.Builder()
				.setBeginningLevels(beginningLevels)
				.setEndingLevels(endingLevels)
				.setConversionTargets(conversionTargets)
				.Build();
	}

}
