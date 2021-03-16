package com.ytosko.twc.retronews;

public class newshelper {
    private String name, link;

    public newshelper() {
    }

    public newshelper(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public newshelper setName(String name) {
        this.name = name;
        return this;
    }

    public String getLink() {
        return link;
    }

    public newshelper setLink(String link) {
        this.link = link;
        return this;
    }
}
