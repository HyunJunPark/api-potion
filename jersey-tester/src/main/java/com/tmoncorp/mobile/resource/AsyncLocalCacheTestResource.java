package com.tmoncorp.mobile.resource;

import com.tmoncorp.mobile.repository.CacheTestRepository;
import com.tmoncorp.mobile.util.common.cache.Cache;
import com.tmoncorp.mobile.util.common.cache.CacheStorage;
import com.tmoncorp.mobile.util.common.cache.CacheType;
import com.tmoncorp.mobile.util.common.cache.httpcache.HttpCacheType;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/local/async")
public class AsyncLocalCacheTestResource {



	@Inject
	CacheTestRepository cacheTestRepository;

	@GET
	@Cache(type = CacheType.ASYNC, storage = CacheStorage.LOCAL, expiration = 4)
	@Path("default")
	public String getSync(){
		return cacheTestRepository.makeValue();
	}

	@GET
	@Cache(type = CacheType.ASYNC,storage = CacheStorage.LOCAL,expiration = 4,setOnError = false)
	@Path("setOnError")
	public String getSetOnError(){
		return cacheTestRepository.makeOnce();
	}

	@GET
	@Cache(type = CacheType.ASYNC,storage = CacheStorage.LOCAL,expiration = 4,compress=true)
	@Path("compress")
	public Object getCompressed(){
		return cacheTestRepository.makeValue();
	}

	@GET
	@Cache(type = CacheType.ASYNC,storage = CacheStorage.LOCAL,expiration = 4, browserCache = HttpCacheType.NONE)
	@Path("browserCache")
	public String getBrowserCacheNone(){
		return cacheTestRepository.makeValue();
	}

}
