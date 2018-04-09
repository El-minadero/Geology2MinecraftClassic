package net.kevinmendoza.geology2minecraftclassic.main;

import java.util.HashMap;

import com.google.inject.Guice;
import com.google.inject.Injector;

import net.kevinmendoza.geology2minecraftclassic.configuration.ConfigBind;
import net.kevinmendoza.geoworldlibrary.utilities.IBlockStateCreator;

class ConverterMap {
	
	private ConverterFactory factory;
	private HashMap<Long,IBlockStateCreator> stratigrapyMap;
	
	public ConverterMap() {
		Injector injector = Guice.createInjector(new ConfigBind());
		factory = injector.getInstance(ConverterFactory.class);
		stratigrapyMap=new HashMap<>();
	}

	public IBlockStateCreator getCreator(long seed,boolean newInstance) {
		if(newInstance) {
			return factory.createBlockStateCreator(seed);
		}
		else {
			return returnMapValue(seed);
		}
	}


	private  IBlockStateCreator returnMapValue(long seed) {
		if(stratigrapyMap.containsKey(seed)) {
			return stratigrapyMap.get(seed);
		}
		else {
			return createNewInstance(seed);
		}
	}

	private  IBlockStateCreator createNewInstance(long seed) {
		IBlockStateCreator geology = factory.createBlockStateCreator(seed);
		stratigrapyMap.put(seed, geology);
		return geology;
	}

}
