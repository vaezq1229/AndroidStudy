package com.lwh.mystudy.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ...
 * Created by xingshijie on 2017/4/19.
 */
public class HttpLogCache {

    //保存多少次请求
    private static final int LOGGER_SIZE = 10;
    private static Map<String, HttpLogCache> loggerMap = new ConcurrentHashMap<>();
    private List<HttpLogger> mLoggerList = new ArrayList<>(LOGGER_SIZE);

    private HttpLogCache() {
    }

    public synchronized static HttpLogger getHttpLogger(String tag) {
        HttpLogCache httpLogCache = loggerMap.get(tag);
        if (httpLogCache == null) {
            httpLogCache = new HttpLogCache();
            loggerMap.put(tag, httpLogCache);
        }
        HttpLogger httpLogger = new HttpLogger();
        httpLogCache.addHttpLogger(httpLogger);

        return httpLogger;
    }

    public static List<String> getLogList() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (HttpLogCache logCache : loggerMap.values()) {
            for (HttpLogger httpLogger : logCache.mLoggerList) {
                arrayList.addAll(httpLogger.logList);
            }
        }

        return arrayList;
    }

    private void addHttpLogger(HttpLogger logger) {
        if (mLoggerList.size() >= LOGGER_SIZE) {
            mLoggerList.remove(mLoggerList.size() - 1);
        }
        mLoggerList.add(0, logger);
    }

    public static class HttpLogger {
        private List<String> logList = new ArrayList<>();

        public void log(String log) {
            logList.add(log);
        }
    }
}
