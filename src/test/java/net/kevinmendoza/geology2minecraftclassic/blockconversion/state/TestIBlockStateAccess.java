package net.kevinmendoza.geology2minecraftclassic.blockconversion.state;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.annotation.Target;
import java.util.Optional;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.immutable.block.ImmutableStoneData;
import org.spongepowered.api.data.manipulator.mutable.block.StoneData;
import org.spongepowered.api.data.type.StoneTypes;
import org.spongepowered.api.data.value.immutable.ImmutableValueStore;

import net.kevinmendoza.geology2minecraftclassic.configuration.IBlockStateDefaults;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestIBlockStateAccess {
	
	private static BlockStateFactory factory;
	
	private BlockState getGraniteState() {
		BlockState stone = BlockTypes.STONE.getDefaultState();
		Optional<ImmutableStoneData> stoneStateData =stone.get(ImmutableStoneData.class);
		StoneData granite = stoneStateData.get().asMutable().set(Keys.STONE_TYPE,StoneTypes.GRANITE);
		return stone.copy().with(granite.asImmutable()).get();
		
	}
	@BeforeAll
	static void setUp() {
		factory = new BlockStateFactory(); 
	}

	@Test
	void testGranite() {
		BlockState target = getGraniteState();
		IBlockStateDefaults graniteDefaults = new TestBlockDefaults.Builder()
				.setStateAccessDefaults(new TestAccessDefaultsSingleBlock("granite", null))
				.build();
		IBlockStateAccess access = factory.createBlockStateAccess(graniteDefaults);
		BlockState source = access.getState();
		assertEquals(target.getId(), source.getId(),"Source and target blocks for granite not equal. Source ID:"
				+ source.getId() + " . Target ID:" + target.getId());
	}
	
}
