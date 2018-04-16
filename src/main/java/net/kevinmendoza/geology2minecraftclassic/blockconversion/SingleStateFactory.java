package net.kevinmendoza.geology2minecraftclassic.blockconversion;

import com.google.inject.Inject;

import net.kevinmendoza.geology2minecraftclassic.blockconversion.blockdata.BaseBlockState;
import net.kevinmendoza.geology2minecraftclassic.blockconversion.metamorphic.IMetaControl;
import net.kevinmendoza.geology2minecraftclassic.blockconversion.metamorphic.MetamorphicControlFactory;
import net.kevinmendoza.geology2minecraftclassic.blockconversion.ore.IOreControl;
import net.kevinmendoza.geology2minecraftclassic.blockconversion.ore.OreControlFactory;
import net.kevinmendoza.geology2minecraftclassic.blockconversion.state.BlockStateFactory;
import net.kevinmendoza.geology2minecraftclassic.blockconversion.state.IBlockStateAccess;
import net.kevinmendoza.geology2minecraftclassic.configuration.IBlockStateDefaults;

public class SingleStateFactory implements IStateFactory {
	
	private OreControlFactory oreFactory;
	private MetamorphicControlFactory metaFactory;
	private BlockStateFactory blockStateFactory;
	private MetadataFactory metadataFactory;
	
	
	public SingleStateFactory(){
		oreFactory 	= new OreControlFactory();
		metaFactory = new MetamorphicControlFactory();
		blockStateFactory = new BlockStateFactory();
		metadataFactory = new MetadataFactory();
	}
	
	@Override
	public IBlockBase createState(IBlockStateDefaults defaults) {
		IMetaControl metaControl 	= metaFactory.createMetamorphicControl(defaults);
		IOreControl  oreControl		= oreFactory.createOreControl(defaults);
		IBlockStateAccess blockStateAccess = blockStateFactory.createBlockStateAccess(defaults);
		IBlockMetadata metadata		= metadataFactory.getMetadata();
		
		return new BaseBlockState.Builder()
				.setMetaControl(metaControl)
				.setOreControl(oreControl)
				.setState(blockStateAccess)
				.setMetadata(metadata)
				.Build();
				
	}

	
	
	
}
