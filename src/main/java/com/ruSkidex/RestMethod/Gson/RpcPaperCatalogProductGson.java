package com.ruSkidex.RestMethod.Gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RpcPaperCatalogProductGson {
    public class AdditionalData {

        @SerializedName("pagesCount")
        @Expose
        private Integer pagesCount;
        @SerializedName("totalCount")
        @Expose
        private Integer totalCount;

        public Integer getPagesCount() {
            return pagesCount;
        }

        public void setPagesCount(Integer pagesCount) {
            this.pagesCount = pagesCount;
        }

        public Integer getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }

    }
public class Catalog {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("beginsAt")
        @Expose
        private String beginsAt;
        @SerializedName("endsAt")
        @Expose
        private String endsAt;
        @SerializedName("maxDiscount")
        @Expose
        private Integer maxDiscount;
        @SerializedName("productCount")
        @Expose
        private Integer productCount;
        @SerializedName("shopCount")
        @Expose
        private Integer shopCount;
        @SerializedName("pdfUrl")
        @Expose
        private Object pdfUrl;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("categoryIds")
        @Expose
        private List<Object> categoryIds = null;
        @SerializedName("status")
        @Expose
        private String status;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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

        public Integer getMaxDiscount() {
            return maxDiscount;
        }

        public void setMaxDiscount(Integer maxDiscount) {
            this.maxDiscount = maxDiscount;
        }

        public Integer getProductCount() {
            return productCount;
        }

        public void setProductCount(Integer productCount) {
            this.productCount = productCount;
        }

        public Integer getShopCount() {
            return shopCount;
        }

        public void setShopCount(Integer shopCount) {
            this.shopCount = shopCount;
        }

        public Object getPdfUrl() {
            return pdfUrl;
        }

        public void setPdfUrl(Object pdfUrl) {
            this.pdfUrl = pdfUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<Object> getCategoryIds() {
            return categoryIds;
        }

        public void setCategoryIds(List<Object> categoryIds) {
            this.categoryIds = categoryIds;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }

public class Category {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("children")
        @Expose
        private List<Object> children = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<Object> getChildren() {
            return children;
        }

        public void setChildren(List<Object> children) {
            this.children = children;
        }

    }
public class Company {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("imageRounded")
        @Expose
        private String imageRounded;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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
public static class MethodPaperCatalogsProductsRPC {

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
public class Payload {

        @SerializedName("hasEnded")
        @Expose
        private Boolean hasEnded;
        @SerializedName("company")
        @Expose
        private Company company;
        @SerializedName("category")
        @Expose
        private Object category;
        @SerializedName("stats")
        @Expose
        private Stats stats;
        @SerializedName("catalogs")
        @Expose
        private List<Catalog> catalogs = null;
        @SerializedName("products")
        @Expose
        private List<Product> products = null;
        @SerializedName("categories")
        @Expose
        private List<Category> categories = null;
        @SerializedName("shoppingList")
        @Expose
        private List<Object> shoppingList = null;
        @SerializedName("shopAddresses")
        @Expose
        private List<ShopAddress> shopAddresses = null;
        @SerializedName("additionalData")
        @Expose
        private AdditionalData additionalData;
        @SerializedName("rootUrl")
        @Expose
        private String rootUrl;
        @SerializedName("categoryId")
        @Expose
        private Object categoryId;
        @SerializedName("currentPage")
        @Expose
        private Integer currentPage;
        @SerializedName("sortLinks")
        @Expose
        private List<SortLink> sortLinks = null;
        @SerializedName("code")
        @Expose
        private Integer code;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("message")
        @Expose
        private String message;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Boolean getHasEnded() {
            return hasEnded;
        }

        public void setHasEnded(Boolean hasEnded) {
            this.hasEnded = hasEnded;
        }

        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }

        public Object getCategory() {
            return category;
        }

        public void setCategory(Object category) {
            this.category = category;
        }

        public Stats getStats() {
            return stats;
        }

        public void setStats(Stats stats) {
            this.stats = stats;
        }

        public List<Catalog> getCatalogs() {
            return catalogs;
        }

        public void setCatalogs(List<Catalog> catalogs) {
            this.catalogs = catalogs;
        }

        public List<Product> getProducts() {
            return products;
        }

        public void setProducts(List<Product> products) {
            this.products = products;
        }

        public List<Category> getCategories() {
            return categories;
        }

        public void setCategories(List<Category> categories) {
            this.categories = categories;
        }

        public List<Object> getShoppingList() {
            return shoppingList;
        }

        public void setShoppingList(List<Object> shoppingList) {
            this.shoppingList = shoppingList;
        }

        public List<ShopAddress> getShopAddresses() {
            return shopAddresses;
        }

        public void setShopAddresses(List<ShopAddress> shopAddresses) {
            this.shopAddresses = shopAddresses;
        }



        public AdditionalData getAdditionalData() {
            return additionalData;
        }

        public void setAdditionalData(AdditionalData additionalData) {
            this.additionalData = additionalData;
        }

        public String getRootUrl() {
            return rootUrl;
        }

        public void setRootUrl(String rootUrl) {
            this.rootUrl = rootUrl;
        }

        public Object getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Object categoryId) {
            this.categoryId = categoryId;
        }

        public Integer getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(Integer currentPage) {
            this.currentPage = currentPage;
        }

        public List<SortLink> getSortLinks() {
            return sortLinks;
        }

        public void setSortLinks(List<SortLink> sortLinks) {
            this.sortLinks = sortLinks;
        }

    }
public class Product {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("productCardId")
        @Expose
        private Integer productCardId;
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
        private float price;
        @SerializedName("priceFormatted")
        @Expose
        private String priceFormatted;
        @SerializedName("oldPrice")
        @Expose
        private float oldPrice;
        @SerializedName("oldPriceFormatted")
        @Expose
        private String oldPriceFormatted;
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

        public float getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public String getPriceFormatted() {
            return priceFormatted;
        }

        public void setPriceFormatted(String priceFormatted) {
            this.priceFormatted = priceFormatted;
        }

        public float getOldPrice() {
            return oldPrice;
        }

        public void setOldPrice(Integer oldPrice) {
            this.oldPrice = oldPrice;
        }

        public String getOldPriceFormatted() {
            return oldPriceFormatted;
        }

        public void setOldPriceFormatted(String oldPriceFormatted) {
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

    }
public class ShopAddress {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("address")
        @Expose
        private String address;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

    }
public class SortLink {

        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("active")
        @Expose
        private Boolean active;
        @SerializedName("dirRevert")
        @Expose
        private Boolean dirRevert;
        @SerializedName("url")
        @Expose
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Boolean getActive() {
            return active;
        }

        public void setActive(Boolean active) {
            this.active = active;
        }

        public Boolean getDirRevert() {
            return dirRevert;
        }

        public void setDirRevert(Boolean dirRevert) {
            this.dirRevert = dirRevert;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }
public class Stats {

        @SerializedName("maxDiscount")
        @Expose
        private Integer maxDiscount;
        @SerializedName("productCount")
        @Expose
        private Integer productCount;
        @SerializedName("shopCount")
        @Expose
        private Integer shopCount;

        public Integer getMaxDiscount() {
            return maxDiscount;
        }

        public void setMaxDiscount(Integer maxDiscount) {
            this.maxDiscount = maxDiscount;
        }

        public Integer getProductCount() {
            return productCount;
        }

        public void setProductCount(Integer productCount) {
            this.productCount = productCount;
        }

        public Integer getShopCount() {
            return shopCount;
        }

        public void setShopCount(Integer shopCount) {
            this.shopCount = shopCount;
        }

    }

}
