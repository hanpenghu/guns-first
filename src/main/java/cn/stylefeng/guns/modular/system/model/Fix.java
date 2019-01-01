package cn.stylefeng.guns.modular.system.model;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.UUID;

/**
 * <p>
 * 汽车维修项目表
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-25
 */
@TableName("han_fix")
public class Fix extends Model<Fix> {

    private static final long serialVersionUID = 1L;

    /**
     * 维修id
     */
    private String id;
    /**
     * 维修用户id
     */
    @TableField("custom_id")
    private String customId;
    /**
     * 是否已经付款,填写是或者不是
     */
    private String ispay;
    /**
     * 该次维修费用
     */
    private BigDecimal cost;
    /**
     * 客户维修车型
     */
    private String car01;
    /**
     * 维修项目
     */
    @TableField("fix_program")
    private String fixProgram;
    /**
     * 维修时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @TableField("fix_time")
    private Date fixTime;
    /**
     * 使用零件
     */
    @TableField("use_part")
    private String usePart;
    /**
     * 备注
     */
    private String rem01;
    /**
     * 创建人
     */
    @TableField("create_by")
    private String createBy;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @TableField("create_time")
    private Date createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public String getIspay() {
        return ispay;
    }

    public void setIspay(String ispay) {
        this.ispay = ispay;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getCar01() {
        return car01;
    }

    public void setCar01(String car01) {
        this.car01 = car01;
    }

    public String getFixProgram() {
        return fixProgram;
    }

    public void setFixProgram(String fixProgram) {
        this.fixProgram = fixProgram;
    }

    public Date getFixTime() {
        return fixTime;
    }

    public void setFixTime(Date fixTime) {
        this.fixTime = fixTime;
    }

    public String getUsePart() {
        return usePart;
    }

    public void setUsePart(String usePart) {
        this.usePart = usePart;
    }

    public String getRem01() {
        return rem01;
    }

    public void setRem01(String rem01) {
        this.rem01 = rem01;
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
        return "Fix{" +
        ", id=" + id +
        ", customId=" + customId +
        ", ispay=" + ispay +
        ", cost=" + cost +
        ", car01=" + car01 +
        ", fixProgram=" + fixProgram +
        ", fixTime=" + fixTime +
        ", usePart=" + usePart +
        ", rem01=" + rem01 +
        ", createBy=" + createBy +
        ", createTime=" + createTime +
        "}";
    }
}
