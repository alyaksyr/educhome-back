package ci.educhome.web.services;

import ci.educhome.web.entities.SitePage;

public interface SitePageService extends Service<SitePage, Integer> {
	
	public SitePage findByPageCode(String code);
}
