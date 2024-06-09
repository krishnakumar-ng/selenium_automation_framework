package com.selenium.automation.contexts;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class TestContext {
    public Map<String,Object> session = new ConcurrentHashMap<>();
}
