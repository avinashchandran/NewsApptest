package com.news.news;

public class Newsmodel {

    public Newsmodel(String id, String pid, String time, String time_pst, String pname, String is_favorite, String position, String title, String details, String source, String source_name, String source_url, String source_logo, String hash_url, String type, String player_image_url) {
        this.id = id;
        this.pid = pid;
        this.time = time;
        this.time_pst = time_pst;
        this.pname = pname;
        this.is_favorite = is_favorite;
        this.position = position;
        this.title = title;
        this.details = details;
        this.source = source;
        this.source_name = source_name;
        this.source_url = source_url;
        this.source_logo = source_logo;
        this.hash_url = hash_url;
        this.type = type;
        this.player_image_url = player_image_url;
    }

    String id, pid, time, time_pst, pname, is_favorite, position, title, details, source, source_name, source_url,
            source_logo, hash_url, type, player_image_url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime_pst() {
        return time_pst;
    }

    public void setTime_pst(String time_pst) {
        this.time_pst = time_pst;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getIs_favorite() {
        return is_favorite;
    }

    public void setIs_favorite(String is_favorite) {
        this.is_favorite = is_favorite;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public String getSource_logo() {
        return source_logo;
    }

    public void setSource_logo(String source_logo) {
        this.source_logo = source_logo;
    }

    public String getHash_url() {
        return hash_url;
    }

    public void setHash_url(String hash_url) {
        this.hash_url = hash_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlayer_image_url() {
        return player_image_url;
    }

    public void setPlayer_image_url(String player_image_url) {
        this.player_image_url = player_image_url;
    }
}