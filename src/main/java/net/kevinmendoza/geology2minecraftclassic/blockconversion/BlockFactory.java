package net.kevinmendoza.geology2minecraftclassic.blockconversion;

import com.google.inject.Inject;

import net.kevinmendoza.geology2minecraftclassic.blockconversion.blockdata.BaseBlockState;
import net.kevinmendoza.geology2minecraftclassic.blockconversion.metamorphic.IMetaControl;
import net.kevinmendoza.geology2minecraftclassic.blockconversion.metamorphic.MetamorphicControlFactory;
import net.kevinmendoza.geology2minecraftclassic.blockconversion.ore.IOreControl;
import net.kevinmendoza.geology2minecraftclassic.blockconversion.ore.OreControlFactory;
import net.kevinmendoza.geology2minecraftclassic.blockconversion.state.IBlockStateAccess;
import net.kevinmendoza.geology2minecraftclassic.blockconversion.state.StateAccessFactory;
import net.kevinmendoza.geology2minecraftclassic.configuration.IBlockStateDefaults;

public class BlockFactory implements IStateFactory {
	
	private OreControlFactory oreFactory;
	private MetamorphicControlFactory metaFactory;
	private StateAccessFactory stateAccessFactory;
	private MetadataFactory metadataFactory;
	
	
	public BlockFactory(){
		oreFactory 	= new OreControlFactory();
		metaFactory = new MetamorphicControlFactory();
		stateAccessFactory = new StateAccessFactory();
		metadataFactory = new MetadataFactory();
	}
	
	@Override
	public IBlockBase createState(IBlockStateDefaults defaults) {
		IMetaControl metaControl 	= metaFactory.createMetamorphicControl(defaults);
		IOreControl  oreControl		= oreFactory.createOreControl(defaults);
		IBlockStateAccess blockStateAccess = stateAccessFactory.createBlockStateAccess(defaults);
		IBlockMetadata metadata		= metadataFactory.getMetadata();
		
		return new BaseBlockState.Builder()
				.setMetaControl(metaControl)
				.setOreControl(oreControl)
				.setState(blockStateAccess)
				.setMetadata(metadata)
				.Build();
				
	}

	
	
	
}
