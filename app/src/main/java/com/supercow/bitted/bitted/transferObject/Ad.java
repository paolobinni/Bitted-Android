package com.supercow.bitted.bitted.transferObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by paolobi on 27/11/15.
 */
public class Ad implements TransferObject {

    private String id;
    private String name;
    private String owner;
    private String description;
    private String pic;
    private String city;

    public Ad(String name, String owner, String description, String pic, String city) {
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.pic = pic;
        this.city = city;
    }

    public Ad(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public Map<String, String> toMap(){
        Map<String, String> map = new HashMap();

        map.put("id", id);
        map.put("name", name);
        map.put("owner", owner);
        map.put("description", description);
        map.put("pic", pic);
        map.put("city", city);

        return map;
    }


    @Override
    public String toString() {
        return "Ad{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", description='" + description + '\'' +
                ", pic='" + pic + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}