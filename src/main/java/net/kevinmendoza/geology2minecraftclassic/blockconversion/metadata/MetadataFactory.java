package net.kevinmendoza.geology2minecraftclassic.blockconversion.metadata;
import net.kevinmendoza.geology2minecraftclassic.configuration.IBlockStateDefaults;
import net.kevinmendoza.geology2minecraftclassic.configuration.IMetadataDefaults;

public class MetadataFactory {

	public IBlockMetadata getMetadata(IBlockStateDefaults defaults) {
		IMetadataDefaults metadataDefaults = defaults.getMetadata();
		int texture = parseTexture(metadataDefaults.getTexture());
		return  new Metadata.Builder()
				.setComposition(metadataDefaults.getComposition())
				.setName(metadataDefaults.getName())
				.setStartingBlock(metadataDefaults.isStartingMember())
				.setTexture(texture)
				.build();
				
	}

	private int parseTexture(String texture) {
		int i = 0;
		switch(texture.toLowerCase()) {
		case "amorphous":
			i=0;
			break;
		case "fine":
			i=1;
			break;
		case "medium":
			i=2;
			break;
		default:
			i=3;
			break;
		}
		return i;
	}


}
