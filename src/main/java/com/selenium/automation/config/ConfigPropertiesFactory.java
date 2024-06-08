package com.selenium.automation.config;

import com.selenium.automation.config.converter.StringToBrowserRemoteModeTypeConverter;
import com.selenium.automation.config.converter.StringToRunTypeConverter;
import com.selenium.automation.config.converter.StringToUrlConverter;
import com.selenium.automation.enums.BrowserRemoteModeType;
import com.selenium.automation.enums.RunType;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigCache;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE) // Search for the provided key from any of the file and system variable mentioned in Config.Sources
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config/cucumber.properties",
        "file:${user.dir}/src/test/resources/config/${env}.properties"
})
public interface ConfigPropertiesFactory extends Config {

    public static ConfigPropertiesFactory CONFIG_PROPERTIES = ConfigCache.getOrCreate(ConfigPropertiesFactory.class);

    @DefaultValue("staging")
    String environment();

    @Key("${environment}.url")
    String url();

    String override_report();

    boolean passed_step_screenshots();

    boolean failed_step_screenshots();

    boolean skipped_step_screenshots();

    boolean retry_failed_tests();

    int retry_count();

    @DefaultValue("LOCAL")
    @ConverterClass(StringToRunTypeConverter.class)
    RunType run_mode();

    @DefaultValue("SELENIUMGRID")
    @ConverterClass(StringToBrowserRemoteModeTypeConverter.class)
    BrowserRemoteModeType remote_mode();

    @ConverterClass(StringToUrlConverter.class)
    URL seleniumGridUrl();

    @ConverterClass(StringToUrlConverter.class)
    URL selenoidUrl();
}
