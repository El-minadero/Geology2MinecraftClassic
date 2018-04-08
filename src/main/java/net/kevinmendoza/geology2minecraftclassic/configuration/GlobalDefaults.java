package net.kevinmendoza.geology2minecraftclassic.configuration;

import com.google.common.reflect.TypeToken;

import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@ConfigSerializable
public class GlobalDefaults {
	public static final TypeToken<GlobalDefaults> type = TypeToken.of(GlobalDefaults.class);
}
