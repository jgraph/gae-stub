package com.mxgraph.online;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.spi.CachingProvider;

public class CacheFacade {

	private CacheFacade() {}

	public static Cache<String, String> createCache()
	{
		CachingProvider provider = Caching.getCachingProvider();  
		CacheManager cacheManager = provider.getCacheManager();   
		MutableConfiguration<String, String> configuration =
		    new MutableConfiguration<String, String>()  
		        .setTypes(String.class, String.class)   
		        .setStoreByValue(true)
		        .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(Duration.FIVE_MINUTES));  
		return cacheManager.createCache("jCache", configuration);
	}
}
