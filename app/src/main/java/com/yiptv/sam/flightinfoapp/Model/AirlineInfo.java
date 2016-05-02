package com.yiptv.sam.flightinfoapp.Model;

/**
 * Created by Sam on 5/1/16.
 */
public class AirlineInfo {

    private String Clazz;
    private String code;
    private String defaultName;
    private String logoURL;
    private String name;
    private String phone;
    private String site;
    private String usName;

    /**
     * No args constructor for use in serialization
     *
     */
    public AirlineInfo() {
    }


    public AirlineInfo(String Clazz, String code, String defaultName, String logoURL, String name, String phone, String site, String usName) {
        this.Clazz = Clazz;
        this.code = code;
        this.defaultName = defaultName;
        this.logoURL = logoURL;
        this.name = name;
        this.phone = phone;
        this.site = site;
        this.usName = usName;
    }


    public String getClazz() {
        return Clazz;
    }


    public void setClazz(String Clazz) {
        this.Clazz = Clazz;
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getDefaultName() {
        return defaultName;
    }


    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    public String getLogoURL() {
        return logoURL;
    }


    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getSite() {
        return site;
    }


    public void setSite(String site) {
        this.site = site;
    }


    public String getUsName() {
        return usName;
    }


    public void setUsName(String usName) {
        this.usName = usName;
    }
}
