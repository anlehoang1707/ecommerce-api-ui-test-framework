package model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Coupon {

    private int id;
    private String code;
    private String amount;

    @JsonProperty("date_created")
    private String dateCreated;

    @JsonProperty("date_created_gmt")
    private String dateCreatedGmt;

    @JsonProperty("date_modified")
    private String dateModified;

    @JsonProperty("date_modified_gmt")
    private String dateModifiedGmt;

    @JsonProperty("discount_type")
    private String discountType;

    private String description;

    @JsonProperty("date_expires")
    private String dateExpires;

    @JsonProperty("date_expires_gmt")
    private String dateExpiresGmt;

    @JsonProperty("usage_count")
    private int usageCount;

    @JsonProperty("individual_use")
    private boolean individualUse;

    @JsonProperty("product_ids")
    private List<Integer> productIds;

    @JsonProperty("excluded_product_ids")
    private List<Integer> excludedProductIds;

    @JsonProperty("usage_limit")
    private Integer usageLimit;

    @JsonProperty("usage_limit_per_user")
    private Integer usageLimitPerUser;

    @JsonProperty("limit_usage_to_x_items")
    private Integer limitUsageToXItems;

    @JsonProperty("free_shipping")
    private boolean freeShipping;

    @JsonProperty("product_categories")
    private List<Integer> productCategories;

    @JsonProperty("excluded_product_categories")
    private List<Integer> excludedProductCategories;

    @JsonProperty("exclude_sale_items")
    private boolean excludeSaleItems;

    @JsonProperty("minimum_amount")
    private String minimumAmount;

    @JsonProperty("maximum_amount")
    private String maximumAmount;

    @JsonProperty("email_restrictions")
    private List<String> emailRestrictions;

    @JsonProperty("used_by")
    private List<String> usedBy;

    @JsonProperty("meta_data")
    private List<Object> metaData;

    @JsonProperty("_links")
    private Links links;

    // Add getters and setters here (or use Lombok @Getter/@Setter/@Data if preferred)

    public static class Links {
        private List<LinkItem> self;
        private List<LinkItem> collection;

        public List<LinkItem> getSelf() {
            return self;
        }

        public void setSelf(List<LinkItem> self) {
            this.self = self;
        }

        public List<LinkItem> getCollection() {
            return collection;
        }

        public void setCollection(List<LinkItem> collection) {
            this.collection = collection;
        }

        public static class LinkItem {
            private String href;

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }
    }
}
