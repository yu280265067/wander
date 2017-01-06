package com.ycx.test;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * <p>测试用例基类</p>
 * 不含事务
 * @author Eric.fu
 * @version $Id: BaseTestCase.java, v 0.1 2013-1-4 下午4:28:13 fuyangbiao Exp $
 */
@ContextConfiguration(locations = { "/*/applicationContext.xml" })
public class BaseTestCase extends AbstractJUnit4SpringContextTests {
    protected static Logger      logger = LoggerFactory.getLogger(BaseTestCase.class);

    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Resource(name = "tradeDataSource")
    public void setDataSource(DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
}
