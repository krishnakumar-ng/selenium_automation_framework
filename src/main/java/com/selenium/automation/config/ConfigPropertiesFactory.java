package com.selenium.automation.config;

import com.selenium.automation.config.converter.BrowserRemoteModeConverter;
import com.selenium.automation.config.converter.RunModeConverter;
import com.selenium.automation.config.converter.UrlConverter;
import com.selenium.automation.config.converter.TestEnvConverter;
import com.selenium.automation.enums.BrowserRemoteMode;
import com.selenium.automation.enums.RunMode;
import com.selenium.automation.enums.TestEnv;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigCache;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE) // Search for the provided key from any of the file and system variable mentioned in Config.Sources
@Config.Sources({
        "system:properties",
        "system:env",
        "classpath:cucumber.properties",
        "classpath:${test.env}.properties"
})
public interface ConfigPropertiesFactory extends Config {

    public static ConfigPropertiesFactory CONFIG_PROPERTIES = ConfigCache.getOrCreate(ConfigPropertiesFactory.class);

    @Key("test.env")
    @ConverterClass(TestEnvConverter.class)
    TestEnv testEnv();

    @DefaultValue("LOCAL")
    @Key("run.mode")
    @ConverterClass(RunModeConverter.class)
    RunMode runMode();

    @DefaultValue("SELENIUMGRID")
    @Key("browser.remote.mode")
    @ConverterClass(BrowserRemoteModeConverter.class)
    BrowserRemoteMode browserRemoteMode();

    @Key("selenium.grid.url")
    @ConverterClass(UrlConverter.class)
    URL seleniumGridUrl();

    @Key("selenoid.url")
    @ConverterClass(UrlConverter.class)
    URL selenoidUrl();

    @Key("aut.url")
    String url();
}
