package dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Currency implements Serializable {
    @Id
    @Column(length = 6)
    private String currencyId;
    @Column(length = 30)
    private String description;
    private Date createdDate;
    private Date lastUpdated;
    private String userId;

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyId='" + currencyId + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", lastUpdated=" + lastUpdated +
                ", userId='" + userId + '\'' +
                '}';
    }
}
