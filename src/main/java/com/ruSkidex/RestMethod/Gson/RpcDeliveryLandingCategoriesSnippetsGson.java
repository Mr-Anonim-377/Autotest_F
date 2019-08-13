package com.ruSkidex.RestMethod.Gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RpcDeliveryLandingCategoriesSnippetsGson {



    public class Category {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("parentId")
        @Expose
        private Object parentId;
        @SerializedName("prettyUrl")
        @Expose
        private String prettyUrl;
        @SerializedName("alias")
        @Expose
        private String alias;
        @SerializedName("imageId")
        @Expose
        private Object imageId;
        @SerializedName("image")
        @Expose
        private Object image;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private Object description;
        @SerializedName("root")
        @Expose
        private Integer root;
        @SerializedName("level")
        @Expose
        private Integer level;
        @SerializedName("lft")
        @Expose
        private Integer lft;
        @SerializedName("rgt")
        @Expose
        private Integer rgt;
        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("orderIterator")
        @Expose
        private Integer orderIterator;
        @SerializedName("createdAt")
        @Expose
        private Integer createdAt;
        @SerializedName("updatedAt")
        @Expose
        private Integer updatedAt;
        @SerializedName("products")
        @Expose
        private List<Product> products = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Object getParentId() {
            return parentId;
        }

        public void setParentId(Object parentId) {
            this.parentId = parentId;
        }

        public String getPrettyUrl() {
            return prettyUrl;
        }

        public void setPrettyUrl(String prettyUrl) {
            this.prettyUrl = prettyUrl;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public Object getImageId() {
            return imageId;
        }

        public void setImageId(Object imageId) {
            this.imageId = imageId;
        }

        public Object getImage() {
            return image;
        }

        public void setImage(Object image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public Integer getRoot() {
            return root;
        }

        public void setRoot(Integer root) {
            this.root = root;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public Integer getLft() {
            return lft;
        }

        public void setLft(Integer lft) {
            this.lft = lft;
        }

        public Integer getRgt() {
            return rgt;
        }

        public void setRgt(Integer rgt) {
            this.rgt = rgt;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getOrderIterator() {
            return orderIterator;
        }

        public void setOrderIterator(Integer orderIterator) {
            this.orderIterator = orderIterator;
        }

        public Integer getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Integer createdAt) {
            this.createdAt = createdAt;
        }

        public Integer getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Integer updatedAt) {
            this.updatedAt = updatedAt;
        }

        public List<Product> getProducts() {
            return products;
        }

        public void setProducts(List<Product> products) {
            this.products = products;
        }

    }
public class Company {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("managerId")
        @Expose
        private Integer managerId;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("imageRounded")
        @Expose
        private String imageRounded;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("language")
        @Expose
        private String language;
        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("createdAt")
        @Expose
        private Integer createdAt;
        @SerializedName("updatedAt")
        @Expose
        private Integer updatedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getManagerId() {
            return managerId;
        }

        public void setManagerId(Integer managerId) {
            this.managerId = managerId;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getImageRounded() {
            return imageRounded;
        }

        public void setImageRounded(String imageRounded) {
            this.imageRounded = imageRounded;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Integer createdAt) {
            this.createdAt = createdAt;
        }

        public Integer getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Integer updatedAt) {
            this.updatedAt = updatedAt;
        }

    }
 public class DeliveryLandingCategoriesSnippets {

        @SerializedName("messages")
        @Expose
        private List<Message> messages = null;

        public List<Message> getMessages() {
            return messages;
        }

        public void setMessages(List<Message> messages) {
            this.messages = messages;
        }

    }
public class Message {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("payload")
        @Expose
        private Payload payload;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Payload getPayload() {
            return payload;
        }

        public void setPayload(Payload payload) {
            this.payload = payload;
        }

    }
public class Payload {

        @SerializedName("categories")
        @Expose
        private List<Category> categories = null;
        @SerializedName("company")
        @Expose
        private Company company;

        public List<Category> getCategories() {
            return categories;
        }

        public void setCategories(List<Category> categories) {
            this.categories = categories;
        }

        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }

    }
public class Product {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("productCardId")
        @Expose
        private Integer productCardId;
        @SerializedName("paperCatalogProductId")
        @Expose
        private Integer paperCatalogProductId;
        @SerializedName("catalogId")
        @Expose
        private Integer catalogId;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("price")
        @Expose
        private Double price;
        @SerializedName("priceFormatted")
        @Expose
        private String priceFormatted;
        @SerializedName("oldPrice")
        @Expose
        private Object oldPrice;
        @SerializedName("oldPriceFormatted")
        @Expose
        private Object oldPriceFormatted;
        @SerializedName("discount")
        @Expose
        private Integer discount;
        @SerializedName("beginsAt")
        @Expose
        private String beginsAt;
        @SerializedName("endsAt")
        @Expose
        private String endsAt;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("shoppingList")
        @Expose
        private List<Object> shoppingList = null;
        @SerializedName("measure")
        @Expose
        private String measure;
        @SerializedName("property")
        @Expose
        private Integer property;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getProductCardId() {
            return productCardId;
        }

        public void setProductCardId(Integer productCardId) {
            this.productCardId = productCardId;
        }

        public Integer getPaperCatalogProductId() {
            return paperCatalogProductId;
        }

        public void setPaperCatalogProductId(Integer paperCatalogProductId) {
            this.paperCatalogProductId = paperCatalogProductId;
        }

        public Integer getCatalogId() {
            return catalogId;
        }

        public void setCatalogId(Integer catalogId) {
            this.catalogId = catalogId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public String getPriceFormatted() {
            return priceFormatted;
        }

        public void setPriceFormatted(String priceFormatted) {
            this.priceFormatted = priceFormatted;
        }

        public Object getOldPrice() {
            return oldPrice;
        }

        public void setOldPrice(Object oldPrice) {
            this.oldPrice = oldPrice;
        }

        public Object getOldPriceFormatted() {
            return oldPriceFormatted;
        }

        public void setOldPriceFormatted(Object oldPriceFormatted) {
            this.oldPriceFormatted = oldPriceFormatted;
        }

        public Integer getDiscount() {
            return discount;
        }

        public void setDiscount(Integer discount) {
            this.discount = discount;
        }

        public String getBeginsAt() {
            return beginsAt;
        }

        public void setBeginsAt(String beginsAt) {
            this.beginsAt = beginsAt;
        }

        public String getEndsAt() {
            return endsAt;
        }

        public void setEndsAt(String endsAt) {
            this.endsAt = endsAt;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<Object> getShoppingList() {
            return shoppingList;
        }

        public void setShoppingList(List<Object> shoppingList) {
            this.shoppingList = shoppingList;
        }

        public String getMeasure() {
            return measure;
        }

        public void setMeasure(String measure) {
            this.measure = measure;
        }

        public Integer getProperty() {
            return property;
        }

        public void setProperty(Integer property) {
            this.property = property;
        }

    }


}

