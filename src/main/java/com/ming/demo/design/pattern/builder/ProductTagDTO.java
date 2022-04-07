package com.ming.demo.design.pattern.builder;

/**
 * 实体类建造者链式构建
 * @author Ming
 * @date 7/4/2022-下午 5:20
 */
public class ProductTagDTO {
    private String tagImg;
    private String tag;

    public String getTagImg() {
        return tagImg;
    }

    public void setTagImg(String tagImg) {
        this.tagImg = tagImg;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public ProductTagDTO tagImg(String tagImg){
        this.tagImg = tagImg;
        return this;
    }

    public ProductTagDTO tag(String tag){
        this.tag = tag;
        return this;
    }

    public static ProductTagDTO builder(){
        return new ProductTagDTO();
    }

    public ProductTagDTO build(){
        return this;
    }

    @Override
    public String toString() {
        return "ProductTagDTO{" +
                "tagImg='" + tagImg + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
