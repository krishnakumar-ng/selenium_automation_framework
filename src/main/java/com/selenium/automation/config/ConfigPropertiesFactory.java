package com.selenium.automation.config;

import com.selenium.automation.config.converter.StringToBrowserRemoteModeTypeConverter;
import com.selenium.automation.config.converter.StringToRunTypeConverter;
import com.selenium.automation.config.converter.StringToUrlConverter;
import com.selenium.automation.config.converter.TestEnvConverter;
import com.selenium.automation.enums.BrowserRemoteModeType;
import com.selenium.automation.enums.RunType;
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

    @Key("base.url")
    String url();

    @DefaultValue("LOCAL")
    @Key("run.mode")
    @ConverterClass(StringToRunTypeConverter.class)
    RunType run_mode();

    @DefaultValue("SELENIUMGRID")
    @Key("remote.mode")
    @ConverterClass(StringToBrowserRemoteModeTypeConverter.class)
    BrowserRemoteModeType remote_mode();

    @Key("selenium.grid.url")
    @ConverterClass(StringToUrlConverter.class)
    URL seleniumGridUrl();

    @Key("selenoid.url")
    @ConverterClass(StringToUrlConverter.class)
    URL selenoidUrl();
}
