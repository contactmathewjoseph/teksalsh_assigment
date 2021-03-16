package com.ytosko.twc.retronews;

public class urlhelper {
private String title,url;

    public urlhelper() {
    }

    public urlhelper(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public urlhelper setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public urlhelper setUrl(String url) {
        this.url = url;
        return this;
    }
}
