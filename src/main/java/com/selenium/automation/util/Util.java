package com.selenium.automation.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

@Slf4j
@UtilityClass
public class Util {

    @UtilityClass
    public class Date{
        public String getDate(){
            return DateTime.now().toString();
        }

        public Long getEpoch(){
            return new java.util.Date().getTime();
        }

        public  String getTimeStamp(){
            return new java.util.Date().toString().replaceAll(":", "_")
                    .replaceAll(" ", "_");
        }
    }

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
