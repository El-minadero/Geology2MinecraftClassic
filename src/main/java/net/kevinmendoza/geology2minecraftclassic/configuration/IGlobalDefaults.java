package net.kevinmendoza.geology2minecraftclassic.configuration;

import java.util.List;

import org.spongepowered.api.block.BlockState;

public interface IGlobalDefaults {

	BlockState getDefaultState();

	List<IBlockStateDefaults> getBlockStateList();

}
