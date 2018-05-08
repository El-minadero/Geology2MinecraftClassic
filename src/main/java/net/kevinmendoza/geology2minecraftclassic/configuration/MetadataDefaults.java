package net.kevinmendoza.geology2minecraftclassic.configuration;

import net.kevinmendoza.geoworldlibrary.geology.rockdata.BulkComposition;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@ConfigSerializable
public class MetadataDefaults implements IMetadataDefaults {
	
	@Setting
	private boolean isStartingMember;
	@Setting
	private String name;
	@Setting
	private String texture;
	@Setting
	private String composition;
	
	
	public MetadataDefaults(Builder builder) {
		isStartingMember = builder.isStartingMember();
		name 	= builder.getName();
		texture = builder.getTexture();
		composition= builder.getComposition();
	}
	
	public String getTexture() { return texture; }
	
	public BulkComposition getComposition() {
		switch(composition.toLowerCase()) {
		case "mafic":
			return  BulkComposition.Mafic;
		case "felsic":
			return BulkComposition.Felsic;
		case "silicate":
			return BulkComposition.Silicate;
		case "carbonate":
			return BulkComposition.Carbonate;
		default:
			return BulkComposition.Clay;
		}
	}
	
	public String getName() { return name; }
	public boolean isStartingMember() { return isStartingMember; }

	static class Builder {
	
		private boolean isStartingMember;
		private String name;
		private String texture;
		private String composition;

		Builder setName(String name) {
			this.name = name; return this;
		}
		Builder setTexture(String texture) {
			this.texture=texture; return this;
		}
		Builder setComposition(String comp) {
			this.composition=comp; return this;
		}
		Builder setStart(boolean start) {
			this.isStartingMember=start; return this;
		}

		public String getComposition() { return composition; }
		public String getTexture() { return texture; }
		public String getName() { return name; }
		public boolean isStartingMember() { return isStartingMember; }

		MetadataDefaults build() {
			return new MetadataDefaults(this);
		}
	}

	
}
