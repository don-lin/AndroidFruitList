package com.donlin.fruiteducation;

public class Fruit {
    private String name;
    private int imageId;
    private String introduction;
    public Fruit(String name, int imageId,String introduction) {
        this.name = name;
        this.imageId = imageId;
        this.introduction = introduction;
    }
    public String getName() {
        return name;
    }

    public String getFirstCharacter(){
        if(name.length()==0)
            return "";
        return name.substring(0,1);
    }
    public int getImageId() {
        return imageId;
    }

    public String getIntroduction(){
        return introduction;
    }

    public String toString(){
        return getName()+" - "+getIntroduction();
    }
}