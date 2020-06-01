package com.example.demo.bean;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Appliance {

    @EmbeddedId
    private ApplianceIdentity applianceIdentity;

    @Enumerated(EnumType.STRING)
    private ApplicanceStatus status;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date boughtDate;

    public ApplianceIdentity getApplianceIdentity() {
        return applianceIdentity;
    }

    public void setApplianceIdentity(ApplianceIdentity applianceIdentity) {
        this.applianceIdentity = applianceIdentity;
    }

    public ApplicanceStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicanceStatus status) {
        this.status = status;
    }

    public Date getBoughtDate() {
        return boughtDate;
    }

    public void setBoughtDate(Date boughtDate) {
        this.boughtDate = boughtDate;
    }
}
