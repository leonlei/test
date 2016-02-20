package com.leon.service;

import com.leon.crawler.MyCrawler;
import com.leon.dao.UserMapper;
import com.leon.model.User;
import com.leon.util.HttpUtil;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/2
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 测试
     */
    public void test() throws Exception {
       // HttpUtil.postJson("http://www.91ala.com/deal/cateGory?cid=11","test");
        String crawlStorageFolder = "/data/crawl/root";
        int numberOfCrawlers = 7;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);

        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        /*
         * For each crawl, you need to add some seed urls. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages
         */
        controller.addSeed("http://www.91ala.com/deal/cateGory?cid=6");
        controller.addSeed("http://www.91ala.com/deal/cateGory?cid=3");
        controller.addSeed("http://www.91ala.com/");

        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(MyCrawler.class, numberOfCrawlers);
    }


    public User getUser(Integer userId) throws DataAccessException{
        return userMapper.selectByPrimaryKey(userId);
    }
}
