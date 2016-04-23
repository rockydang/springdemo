package com.rockydang.service.springdemo.api.domain.topic;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 专题实体类
 * </p>
 *
 * @author 延霄
 * @创建时间：2015年11月20日
 * @产品: 市场主题管理系统
 * @version： V1.0
 */
public class TopicDO implements Serializable {

    private static final long serialVersionUID = 7426860969391703717L;

    /**
     * 专题ID，主键、自增
     */
    private Long id;

    /**
     * 专题名称
     */
    private String name;

    /**
     * 市场ID
     */
    private Long marketId;

    /**
     * 专题图片
     */
    private String img;

    /**
     * 专题图片链接
     */
    private String link;

    /**
     * 是否推荐商品：0：否；1：是
     */
    private Integer isRecomItem;

    /**
     * 商品数据来源：（1：商品，2：投放，3：报名，4：麦田）
     */
    private Integer itemDataSource;

    /**
     * 主题推荐商品：json字段【tradeItemId:{title,img}】
     */
    private String itemInfos;

    /**
     * 推荐商品ID
     */
    private String itemIds;

    /**
     * 推荐商品名称
     */
    private String itemNames;

    /**
     * 推荐商品图片
     */
    private String itemImgs;

    /**
     * 推荐商品列表
     */
    private LinkedHashMap<String, Map<String, String>> itemInfosMaps;

    /**
     * 编辑人员ID
     */
    private Integer editorId;

    /**
     * 专题状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Integer created;

    /**
     * 更新时间
     */
    private Integer updated;

    /**
     * 是否删除：0：否；1：是
     */
    private Integer isDeleted;

    /**
     * 商品信息map
     */
    private List<Map<String, String>> itemInfoMaps;

    /**
     * 排序
     */
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getIsRecomItem() {
        return isRecomItem;
    }

    public void setIsRecomItem(Integer isRecomItem) {
        this.isRecomItem = isRecomItem;
    }

    public Integer getItemDataSource() {
        return itemDataSource;
    }

    public void setItemDataSource(Integer itemDataSource) {
        this.itemDataSource = itemDataSource;
    }

    public String getItemInfos() {
        return itemInfos;
    }

    public void setItemInfos(String itemInfos) {
        this.itemInfos = itemInfos;
    }

    public String getItemIds() {
        return itemIds;
    }

    public void setItemIds(String itemIds) {
        this.itemIds = itemIds;
    }

    public String getItemNames() {
        return itemNames;
    }

    public void setItemNames(String itemNames) {
        this.itemNames = itemNames;
    }

    public String getItemImgs() {
        return itemImgs;
    }

    public void setItemImgs(String itemImgs) {
        this.itemImgs = itemImgs;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEditorId() {
        return editorId;
    }

    public void setEditorId(Integer editorId) {
        this.editorId = editorId;
    }

    public LinkedHashMap<String, Map<String, String>> getItemInfosMaps() {
        return itemInfosMaps;
    }

    public void setItemInfosMaps(LinkedHashMap<String, Map<String, String>> itemInfosMaps) {
        this.itemInfosMaps = itemInfosMaps;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<Map<String, String>> getItemInfoMaps() {
        return itemInfoMaps;
    }

    public void setItemInfoMaps(List<Map<String, String>> itemInfoMaps) {
        this.itemInfoMaps = itemInfoMaps;
    }
}
