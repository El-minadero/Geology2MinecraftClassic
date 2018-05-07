package net.kevinmendoza.geology2minecraftclassic.blockconversion.state;

import org.spongepowered.api.block.BlockState;

class SingleStateAccess implements IBlockStateAccess {
	
	private BlockState state;
	
	private SingleStateAccess(Builder builder) {
		this.state = builder.getState();
	}

	public BlockState getState() { return state; }
	
	static class Builder {
		
		private BlockState state;
		
		public Builder setState(BlockState state) { this.state=state; return this; }
		
		public BlockState getState() { return state;}

		IBlockStateAccess build() {
			return new SingleStateAccess(this);
		}
	}

}
