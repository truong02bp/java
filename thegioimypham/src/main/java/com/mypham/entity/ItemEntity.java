package com.mypham.entity;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class ItemEntity  extends BaseEntity
{
    @Column (name = "name" , columnDefinition = "text")
    private String name;
    @Column (name = "content" , columnDefinition = "text")
    private String content;
    @Column (name = "code")
    private String code;
    @Column (name = "categoryid")
    private Long categoryId;
    @Column (name = "giatruoc")
    private String giaTruoc;
    @Column (name = "giasau")
    private String giaSau;
    @Column (name = "sale")
    private Long sale;
    @Column (name = "link" , columnDefinition = "text")
    private String link;
    @Column (name = "khuyenmai" , columnDefinition = "text")
    private String khuyenMai;
    @Column (name = "web")
    private String web;
    @Column (name="shortdescription" , columnDefinition = "text")
    private String shortDescription;

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(String khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public String getGiaTruoc() {
        return giaTruoc;
    }

    public void setGiaTruoc(String giaTruoc) {
        this.giaTruoc = giaTruoc;
    }

    public String getGiaSau() {
        return giaSau;
    }

    public void setGiaSau(String giaSau) {
        this.giaSau = giaSau;
    }

    public Long getSale() {
        return sale;
    }

    public void setSale(Long sale) {
        this.sale = sale;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
