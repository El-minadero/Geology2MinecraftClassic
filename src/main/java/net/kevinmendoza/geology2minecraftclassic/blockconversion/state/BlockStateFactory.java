package net.kevinmendoza.geology2minecraftclassic.blockconversion.state;

import java.util.Optional;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.immutable.block.ImmutableSandData;
import org.spongepowered.api.data.manipulator.immutable.block.ImmutableStoneData;
import org.spongepowered.api.data.manipulator.mutable.block.SandData;
import org.spongepowered.api.data.manipulator.mutable.block.StoneData;
import org.spongepowered.api.data.type.SandTypes;
import org.spongepowered.api.data.type.StoneTypes;

import net.kevinmendoza.geology2minecraftclassic.configuration.IBlockStateAccessDefaults;
import net.kevinmendoza.geology2minecraftclassic.configuration.IBlockStateDefaults;

class BlockStateFactory {
	
	private BlockTypeFactory blockTypeFactory;
	private DataModifierSand sandDataModifiers;
	private DataModifierStone stoneDataModifiers;
	private DataModifiersDirt dirtDataModifiers;
	private DataModifiersClay clayDataModifiers;
	private DataModifiersSandStone sandstoneModifiers;

	public BlockStateFactory() {
		blockTypeFactory = new BlockTypeFactory();
		sandDataModifiers = new DataModifierSand();
		sandstoneModifiers= new DataModifiersSandStone();
		stoneDataModifiers = new DataModifierStone();
		dirtDataModifiers = new DataModifiersDirt();
		clayDataModifiers = new DataModifiersClay();
	}

	public BlockState getBlockState(String type, String variant) {
		BlockType blockType = blockTypeFactory.getType(type);
		BlockState state = null;
		switch(type) {
		case "STONE":
			state = stoneDataModifiers.modifyStoneState(blockType, variant);
			break;
		case "SAND":
			state = sandDataModifiers.modifySandState(blockType, variant);
			break;
		case "SANDSTONE":
			state = sandstoneModifiers.modifySandState(blockType, variant);
			break;
		case "DIRT":
			state = dirtDataModifiers.modifyDirtState(blockType, variant);
			break;
		case "LITHIFIED_CLAY":
			state = clayDataModifiers.modifyClayState(blockType, variant);
			break;
		default:
			state = blockType.getDefaultState();
		}
		return state;
	}

}
