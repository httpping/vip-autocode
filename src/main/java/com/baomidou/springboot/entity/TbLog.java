package com.baomidou.springboot.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author tanping
 * @since 2018-09-19
 */
public class TbLog extends Model<TbLog> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer id;
    /**
     * 请求地址
     */
    private String url;
    /**
     * 请求参数
     */
    private String request;
    /**
     * 返回参数
     */
    private String response;
    /**
     * 接口名称
     */
    private String name;
    /**
     * 对应的站
     */
    private String domian;
    /**
     * 版本
     */
    private String version;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomian() {
        return domian;
    }

    public void setDomian(String domian) {
        this.domian = domian;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TbLog{" +
        ", id=" + id +
        ", url=" + url +
        ", request=" + request +
        ", response=" + response +
        ", name=" + name +
        ", domian=" + domian +
        ", version=" + version +
        "}";
    }
}
