package cn.pku.timetracker.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

/**
 * @ClassName BaesEntity
 * @Description //基类
 * @Author Cedric
 **/
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BaseEntity<T extends BaseEntity> {

    @Id
    private String id = UUID.randomUUID().toString().replace("-", "");
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    private Boolean deleted = false;

    public BaseEntity() {
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }

    public String computeObjectPath() {
        return String.format("/%s/%d", this.getClass().getSimpleName(), id);
    }

    public Date getCreateTime() {
        return createTime;
    }

    public T setCreateTime(Date createTime) {
        this.createTime = createTime;
        return (T) this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public T setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return (T) this;
    }

    public String getId() {
        return id;
    }

    public T setId(String id) {
        if (null == id || "".equals(id)) {
            return (T) this;
        }
        this.id = id;
        return (T) this;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public T setDeleted(Boolean deleted) {
        this.deleted = deleted;
        return (T) this;
    }
}

