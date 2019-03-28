package com.example.lll.wanandroidproject.core.dao;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class HistoryData {
    @Id(autoincrement = true)
    private Long id;
    private long date;

    private String data;

    public HistoryData(Long id, long date, String data) {
        this.id = id;
        this.data = data;
        this.date = date;
    }
    @Generated(hash =422767273 )
    public HistoryData(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
