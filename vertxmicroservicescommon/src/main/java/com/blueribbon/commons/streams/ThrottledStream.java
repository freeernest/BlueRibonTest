package com.blueribbon.commons.streams;

public interface ThrottledStream<T> {
    void incrementLeftQuota();
    void breakQuota();
}
