package com.panshuljindal.retrofitdemo;

public class RetroPhoto {
    private String name;
    private String realname;
    private String  team;
    private String firstappearance;
    private String createdby;
    private String publisher;
    private String imageurl;
    private String bio;

    public RetroPhoto(String name,String realname,String team,String firstappearance,String createdby, String publisher, String imageurl,String bio){
        this.name=name;
        this.realname=realname;
        this.team=team;
        this.firstappearance=firstappearance;
        this.createdby=createdby;
        this.publisher=publisher;
        this.imageurl=imageurl;
        this.bio=bio;
    }
    public String getName(){
        return name;
    }
    public String getRealName(){
        return realname;
    }
    public String getTeam(){
        return team;
    }
    public String getFirstAppearance(){
        return firstappearance;
    }
    public String getCreatedBy(){
        return createdby;
    }
    public String getPublisher(){
        return publisher;
    }
    public String getImageUrl(){
        return imageurl;
    }
    public String getBio(){
        return bio;
    }
}
