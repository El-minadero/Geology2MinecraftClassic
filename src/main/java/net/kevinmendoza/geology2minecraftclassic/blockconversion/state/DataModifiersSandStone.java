package net.kevinmendoza.geology2minecraftclassic.blockconversion.state;

import java.util.HashMap;
import java.util.Optional;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.immutable.block.ImmutableSandData;
import org.spongepowered.api.data.manipulator.mutable.block.SandData;
import org.spongepowered.api.data.type.SandType;
import org.spongepowered.api.data.type.SandTypes;

class DataModifiersSandStone {

	BlockState modifySandState(BlockType blockType, String variant) {
		if(variant.equalsIgnoreCase("red")) {
			return BlockTypes.RED_SANDSTONE.getDefaultState();
		}
		else {
			return BlockTypes.SANDSTONE.getDefaultState();
		}
	}
}
