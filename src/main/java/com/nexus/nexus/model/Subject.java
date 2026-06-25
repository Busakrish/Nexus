package com.nexus.nexus.model;

public class Subject {
    private long id;
    private String name;
    private String colorHex;

    public Subject(String name,String colorHex){
        this.name = name;
        this.colorHex=colorHex;
    }

    public long getId(){return id;}
    public void setId(long id){this.id = id;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getColorHex(){return colorHex;}
    public void setColorHex(String colorHex){this.colorHex = colorHex;}
}

