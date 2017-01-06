package com.ycx.configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.event.ConfigurationEvent;
import org.apache.commons.configuration.event.ConfigurationListener;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/**
 * Description:配置文件工具类
 * 支持热部署
 * author: ycx
 * Date: 16/10/27
 */
public class SystemConfig extends PropertyPlaceholderConfigurer {

    protected static final Logger LOG = LoggerFactory.getLogger(SystemConfig.class);

    private static String localFilePath;

    protected static Resource[] locations;

    private static PropertiesConfiguration config;

    public static synchronized String getProperty(String key) {
        return (String) config.getProperty(key);
    }

    @Override
    protected void loadProperties(Properties props) throws IOException {
        super.loadProperties(props);
        initConfig();
    }

    @Override
    public void setLocations(Resource[] locations) {   //由于location是父类私有，所以需要记录到本类的locations中
        super.setLocations(locations);
        this.locations = locations;
    }

    @Override
    public void setLocation(Resource location) {   //由于location是父类私有，所以需要记录到本类的locations中
        super.setLocation(location);
        this.locations = new Resource[] { location };
    }

    private void initConfig() {
        if (null == config) {
            try {
                //实例化一个PropertiesConfiguration
                localFilePath = locations[0].getFile().getPath();
                config = new PropertiesConfiguration(localFilePath);
                //设置reload策略，这里用当文件被修改之后reload（默认5s中检测一次）
                config.setReloadingStrategy(new FileChangedReloadingStrategy());
                config.addConfigurationListener(new ConfigurationListener() {

                    @Override
                    public void configurationChanged(ConfigurationEvent e) {
                        System.out.println("配置文件更新..." + e.getType());
                        LOG.info("配置文件更新..." + e.getType() + ",url=" + localFilePath);
                        if (PropertiesConfiguration.EVENT_RELOAD == e.getType()) {
                        	System.out.println("配置文件更新..." + e.getType()+"url="+localFilePath);
                            LOG.info("配置文件重载..." + e.getType() + ",url=" + localFilePath);
                            System.out.println("test ==="+getProperty("test"));
                        }
                    }
                });
            } catch (ConfigurationException e) {
                LOG.error("init static block error. ", e);
            } catch (IOException e) {
                LOG.error("init properties error ", e);
            }
        }
    }
}
