package net.kevinmendoza.geology2minecraftclassic.blockconversion.state;

import net.kevinmendoza.geology2minecraftclassic.blockconversion.IBlockMetadata;
import net.kevinmendoza.geology2minecraftclassic.configuration.IBlockStateAccessDefaults;
import net.kevinmendoza.geology2minecraftclassic.configuration.IBlockStateDefaults;
import net.kevinmendoza.geology2minecraftclassic.configuration.IMetaControlDefaults;
import net.kevinmendoza.geology2minecraftclassic.configuration.IMetadataDefaults;
import net.kevinmendoza.geology2minecraftclassic.configuration.IOreControlDefaults;

public class TestBlockDefaults implements IBlockStateDefaults {

	IOreControlDefaults oreControlDefaults;
	IMetaControlDefaults metaControlDefaults;
	IBlockStateAccessDefaults accessDefaults;
	IMetadataDefaults metaDefaults;
	
	public TestBlockDefaults(Builder builder) {
		oreControlDefaults=builder.getOreControl();
		metaControlDefaults=builder.getMetaControl();
		accessDefaults=builder.getAccessDefaults();
		metaDefaults = builder.getMetadataDefaults();
	}

	public IBlockStateAccessDefaults getAccessDefaults() 	{ return accessDefaults; 		}
	public IOreControlDefaults getOreControlDefaults() 		{ return oreControlDefaults; 	}
	public IMetaControlDefaults getMetaControlDefaults() 	{ return metaControlDefaults; 	}
	
	public IMetadataDefaults getMetadata() {return metaDefaults; }
	
	static class Builder {
		IOreControlDefaults oreControlDefaults;
		IMetaControlDefaults metaControlDefaults;
		IBlockStateAccessDefaults accessDefaults;
		IMetadataDefaults metadata;
		
		Builder(){
			oreControlDefaults=null;
			metaControlDefaults=null;
			accessDefaults=null;
			metadata = null;
		}
		
		Builder setMetadataDefaults(IMetadataDefaults defaults) {
			this.metadata=defaults; return this;
		}
		
		Builder setOreControlDefaults(IOreControlDefaults defaults) {
			this.oreControlDefaults=defaults; return this;
		}
		
		Builder setMetaControlDefaults(IMetaControlDefaults defaults) {
			this.metaControlDefaults=defaults; return this;
		}
		
		Builder setStateAccessDefaults(IBlockStateAccessDefaults defaults) {
			this.accessDefaults=defaults; return this;
		}
		
		private IOreControlDefaults getOreControl() { return oreControlDefaults; }
		private IMetaControlDefaults getMetaControl() { return metaControlDefaults; }
		private IBlockStateAccessDefaults getAccessDefaults() {return accessDefaults; }
		public IMetadataDefaults getMetadataDefaults() { return metadata; }
		
		
		IBlockStateDefaults build() {
			return new TestBlockDefaults(this);
		}
	}
}
