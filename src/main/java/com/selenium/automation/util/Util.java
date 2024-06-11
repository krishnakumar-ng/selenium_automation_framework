package com.selenium.automation.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class Util {

    @UtilityClass
    public class Sync{
        public void sleep(Integer secs){
            try{
                Thread.sleep(secs);
            }catch(InterruptedException ignore){
                log.info("Interrupted Exception occurred and skipped while sleeping = {}", ignore.getMessage());
            }
        }
    }

}
