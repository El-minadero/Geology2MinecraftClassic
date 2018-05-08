package net.kevinmendoza.geology2minecraftclassic.blockconversion.metadata;

import net.kevinmendoza.geoworldlibrary.geology.rockdata.BulkComposition;

class Metadata implements IBlockMetadata {
	
	private int texture;
	private boolean startingBlock = false;
	private BulkComposition composition;
	private String name;
	
	private Metadata(Builder builder) {
		texture = builder.getTexture();
		startingBlock=builder.isStartingBlock();
		composition  =builder.getComposition();
		name    = builder.getName();
	}

	public String getName() { return name; }
	public BulkComposition getComposition() { return composition; }
	public boolean isStartingBlock() { return startingBlock; }
	public boolean isAmorphous() {
		return (texture == 0);
	}
	public boolean isFine() {
		return (texture == 1);
	}
	public boolean isMedium() {
		return (texture == 2);
	}
	
	static class Builder {
		private int texture;
		private boolean startingBlock = false;
		private BulkComposition composition;
		private String name;
		
		Builder setTexture(int texture) 	{ this.texture = texture; return this; }
		Builder setStartingBlock(boolean isStartingBlock) { this.startingBlock=isStartingBlock; return this; }
		Builder setComposition(BulkComposition composition) { this.composition = composition; return this; }
		Builder setName(String name) { this.name = name; return this; }
		
		public boolean isStartingBlock() 	  { return startingBlock; }
		public BulkComposition getComposition(){ return composition; }
		public int getTexture() { return texture; }
		public String getName() { return name; }
		
		IBlockMetadata build() {
			return new Metadata(this);
		}
		
	}

}
