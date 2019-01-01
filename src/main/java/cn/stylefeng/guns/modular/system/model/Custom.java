package cn.stylefeng.guns.modular.system.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 汽车维修客户表
 * </p>
 *
 * @author han
 * @since 2018-12-17
 */
@TableName("han_custom")
public class Custom extends Model<Custom> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键,用java随机码
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 客户姓名
     */
    private String name;
    /**
     * 客户年龄
     */
    private Integer age;
    /**
     * 客户电话1
     */
    private String phone01;
    /**
     * 客户电话2
     */
    private String phone02;
    /**
     * 客户电话3
     */
    private String phone03;
    /**
     * 客户电话4
     */
    private String phone04;
    /**
     * 客户常用车型01
     */
    private String car01;
    /**
     * 客户常用车型02
     */
    private String car02;
    /**
     * 客户常用车型03
     */
    private String car03;
    /**
     * 备注一
     */
    private String rem01;
    /**
     * 备注二
     */
    private String rem02;
    /**
     * 备注三
     */
    private String rem03;
    /**
     * 介绍人
     */
    private String introduce;
    /**
     * 介绍人电话
     */
    @TableField("introduce_phone")
    private String introducePhone;
    /**
     * 创建人
     */
    @TableField("create_by")
    private String createBy;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
//    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    @TableField("create_time")
    private Date createTime;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone01() {
        return phone01;
    }

    public void setPhone01(String phone01) {
        this.phone01 = phone01;
    }

    public String getPhone02() {
        return phone02;
    }

    public void setPhone02(String phone02) {
        this.phone02 = phone02;
    }

    public String getPhone03() {
        return phone03;
    }

    public void setPhone03(String phone03) {
        this.phone03 = phone03;
    }

    public String getPhone04() {
        return phone04;
    }

    public void setPhone04(String phone04) {
        this.phone04 = phone04;
    }

    public String getCar01() {
        return car01;
    }

    public void setCar01(String car01) {
        this.car01 = car01;
    }

    public String getCar02() {
        return car02;
    }

    public void setCar02(String car02) {
        this.car02 = car02;
    }

    public String getCar03() {
        return car03;
    }

    public void setCar03(String car03) {
        this.car03 = car03;
    }

    public String getRem01() {
        return rem01;
    }

    public void setRem01(String rem01) {
        this.rem01 = rem01;
    }

    public String getRem02() {
        return rem02;
    }

    public void setRem02(String rem02) {
        this.rem02 = rem02;
    }

    public String getRem03() {
        return rem03;
    }

    public void setRem03(String rem03) {
        this.rem03 = rem03;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getIntroducePhone() {
        return introducePhone;
    }

    public void setIntroducePhone(String introducePhone) {
        this.introducePhone = introducePhone;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Custom{" +
        ", id=" + id +
        ", name=" + name +
        ", age=" + age +
        ", phone01=" + phone01 +
        ", phone02=" + phone02 +
        ", phone03=" + phone03 +
        ", phone04=" + phone04 +
        ", car01=" + car01 +
        ", car02=" + car02 +
        ", car03=" + car03 +
        ", rem01=" + rem01 +
        ", rem02=" + rem02 +
        ", rem03=" + rem03 +
        ", introduce=" + introduce +
        ", introducePhone=" + introducePhone +
        ", createBy=" + createBy +
        ", createTime=" + createTime +
        "}";
    }
}
