package com.example.demo.bean;

import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ApplianceIdentity implements Serializable {

    //@NotNull(message = "serialNumber can not be null")
    //@Size(max = 100)
    //@Pattern(regexp="[A-Za-z0-9]+$")
    private String serialNumber;

    //@NotNull(message = "brand can not be null")
    //@Size(max = 100)
    //@Pattern(regexp="[A-Za-z0-9 ]+$")
    private String brand;

    //@NotNull(message = "model can not be null")
    //@Size(max = 100)
    //@Pattern(regexp="[A-Za-z0-9 ]+$")
    private String model;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
