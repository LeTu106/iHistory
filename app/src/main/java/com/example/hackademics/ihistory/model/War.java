package com.example.hackademics.ihistory.model;

/**
 * Created by Nhan on 01/08/2015.
 */
public class War {
    public War(String name, String link, String war_name) {
        this.name = name;
        this.link = link;
        this.war_name = war_name;
    }

    private String name;
    private String link;
    private String war_name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getWar_name() {
        return war_name;
    }

    public void setWar_name(String war_name) {
        this.war_name = war_name;
    }



}
