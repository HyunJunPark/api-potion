package com.tmoncorp.mobile.util.spring.version;

import com.tmoncorp.mobile.util.common.cache.CacheProvider;
import com.tmoncorp.mobile.util.common.version.BuildInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/version")
public class VersionController {

	private static Logger LOGGER = LoggerFactory.getLogger(VersionController.class);

	@Autowired
	private ManifestService manifestService;

	@RequestMapping(method = { RequestMethod.GET }, value = { "/buildInfo" })
	@ResponseBody
	public BuildInfo getBuildInfo(){
		try {
			return manifestService.getBuildInfo();
		}catch(Exception e){
			LOGGER.error("getBuildInfo failed, {}",e.getMessage());
			return null;
		}
	}
}
