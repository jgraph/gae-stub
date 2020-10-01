package com.mxgraph.online;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.spi.CachingProvider;

import org.memcached.jcache.MemcachedCachingProvider;
import org.ehcache.jsr107.EhcacheCachingProvider;

public class CacheFacade {

	private CacheFacade() {}

	public static Cache<String, String> createCache(String name, int expirationDelta)
	{
		String memcachedEndpoint = System.getenv().get("DRAWIO_MEMCACHED_ENDPOINT");
		CachingProvider provider;
		CacheManager cacheManager;

		if (memcachedEndpoint != null)
		{
			provider = Caching.getCachingProvider(MemcachedCachingProvider.class.getName());
			Properties properties = provider.getDefaultProperties();
			properties.setProperty("servers", memcachedEndpoint);
			properties.setProperty(name + ".useSharedClientConnection", "true");
			cacheManager = provider.getCacheManager(
                provider.getDefaultURI(), null, properties);
		}
		else
		{
			provider = Caching.getCachingProvider(EhcacheCachingProvider.class.getName());
			cacheManager = provider.getCacheManager();
		}
		
		MutableConfiguration<String, String> configuration =
		    new MutableConfiguration<String, String>()  
		        .setTypes(String.class, String.class)   
		        .setStoreByValue(false) //Memcached does not support store by value
		        .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(new Duration(TimeUnit.SECONDS, expirationDelta)));  
		return cacheManager.createCache(name, configuration);
	}

	public static String getStatistics()
	{
		//TODO implement this for memcached
		return "NYI";
	}
}
