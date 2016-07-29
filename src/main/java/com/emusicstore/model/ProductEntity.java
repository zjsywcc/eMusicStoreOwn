package com.emusicstore.model;

import javax.persistence.*;

/**
 * Created by wcc on 2016/7/29.
 */
@Entity
@Table(name = "product", schema = "", catalog = "emusicstoreown")
public class ProductEntity {
    private int productid;
    private String productcategory;
    private String productcondition;
    private String productdescription;
    private String productmanufacturer;
    private String productname;
    private String productprice;
    private String productstatus;
    private String unitinstock;

    @Id
    @Column(name = "productid")
    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    @Basic
    @Column(name = "productcategory")
    public String getProductcategory() {
        return productcategory;
    }

    public void setProductcategory(String productcategory) {
        this.productcategory = productcategory;
    }

    @Basic
    @Column(name = "productcondition")
    public String getProductcondition() {
        return productcondition;
    }

    public void setProductcondition(String productcondition) {
        this.productcondition = productcondition;
    }

    @Basic
    @Column(name = "productdescription")
    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    @Basic
    @Column(name = "productmanufacturer")
    public String getProductmanufacturer() {
        return productmanufacturer;
    }

    public void setProductmanufacturer(String productmanufacturer) {
        this.productmanufacturer = productmanufacturer;
    }

    @Basic
    @Column(name = "productname")
    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    @Basic
    @Column(name = "productprice")
    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }

    @Basic
    @Column(name = "productstatus")
    public String getProductstatus() {
        return productstatus;
    }

    public void setProductstatus(String productstatus) {
        this.productstatus = productstatus;
    }

    @Basic
    @Column(name = "unitinstock")
    public String getUnitinstock() {
        return unitinstock;
    }

    public void setUnitinstock(String unitinstock) {
        this.unitinstock = unitinstock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity that = (ProductEntity) o;

        if (productid != that.productid) return false;
        if (productcategory != null ? !productcategory.equals(that.productcategory) : that.productcategory != null)
            return false;
        if (productcondition != null ? !productcondition.equals(that.productcondition) : that.productcondition != null)
            return false;
        if (productdescription != null ? !productdescription.equals(that.productdescription) : that.productdescription != null)
            return false;
        if (productmanufacturer != null ? !productmanufacturer.equals(that.productmanufacturer) : that.productmanufacturer != null)
            return false;
        if (productname != null ? !productname.equals(that.productname) : that.productname != null) return false;
        if (productprice != null ? !productprice.equals(that.productprice) : that.productprice != null) return false;
        if (productstatus != null ? !productstatus.equals(that.productstatus) : that.productstatus != null)
            return false;
        if (unitinstock != null ? !unitinstock.equals(that.unitinstock) : that.unitinstock != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productid;
        result = 31 * result + (productcategory != null ? productcategory.hashCode() : 0);
        result = 31 * result + (productcondition != null ? productcondition.hashCode() : 0);
        result = 31 * result + (productdescription != null ? productdescription.hashCode() : 0);
        result = 31 * result + (productmanufacturer != null ? productmanufacturer.hashCode() : 0);
        result = 31 * result + (productname != null ? productname.hashCode() : 0);
        result = 31 * result + (productprice != null ? productprice.hashCode() : 0);
        result = 31 * result + (productstatus != null ? productstatus.hashCode() : 0);
        result = 31 * result + (unitinstock != null ? unitinstock.hashCode() : 0);
        return result;
    }
}
