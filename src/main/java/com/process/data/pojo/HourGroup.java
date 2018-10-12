package com.process.data.pojo;

import java.math.BigDecimal;

public class HourGroup {
    private Integer id;

    private BigDecimal hourData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getHourData() {
        return hourData;
    }

    public void setHourData(BigDecimal hourData) {
        this.hourData = hourData;
    }
}