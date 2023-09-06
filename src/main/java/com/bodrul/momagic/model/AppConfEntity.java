package com.bodrul.momagic.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "app_conf", schema = "smsgw_demo", catalog = "")
public class AppConfEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "app_name")
    private String appName;
    @Basic
    @Column(name = "number_of_thread")
    private int numberOfThread;
    @Basic
    @Column(name = "number_of_row")
    private Integer numberOfRow;
    @Basic
    @Column(name = "status")
    private int status;
    @Basic
    @Column(name = "last_start_time")
    private Timestamp lastStartTime;
    @Basic
    @Column(name = "last_stop_time")
    private Timestamp lastStopTime;
    @Basic
    @Column(name = "stop_by")
    private String stopBy;
    @Basic
    @Column(name = "data_reload")
    private int dataReload;
    @Basic
    @Column(name = "last_reload_time")
    private Timestamp lastReloadTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getNumberOfThread() {
        return numberOfThread;
    }

    public void setNumberOfThread(int numberOfThread) {
        this.numberOfThread = numberOfThread;
    }

    public Integer getNumberOfRow() {
        return numberOfRow;
    }

    public void setNumberOfRow(Integer numberOfRow) {
        this.numberOfRow = numberOfRow;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getLastStartTime() {
        return lastStartTime;
    }

    public void setLastStartTime(Timestamp lastStartTime) {
        this.lastStartTime = lastStartTime;
    }

    public Timestamp getLastStopTime() {
        return lastStopTime;
    }

    public void setLastStopTime(Timestamp lastStopTime) {
        this.lastStopTime = lastStopTime;
    }

    public String getStopBy() {
        return stopBy;
    }

    public void setStopBy(String stopBy) {
        this.stopBy = stopBy;
    }

    public int getDataReload() {
        return dataReload;
    }

    public void setDataReload(int dataReload) {
        this.dataReload = dataReload;
    }

    public Timestamp getLastReloadTime() {
        return lastReloadTime;
    }

    public void setLastReloadTime(Timestamp lastReloadTime) {
        this.lastReloadTime = lastReloadTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppConfEntity that = (AppConfEntity) o;
        return id == that.id && numberOfThread == that.numberOfThread && status == that.status && dataReload == that.dataReload && Objects.equals(appName, that.appName) && Objects.equals(numberOfRow, that.numberOfRow) && Objects.equals(lastStartTime, that.lastStartTime) && Objects.equals(lastStopTime, that.lastStopTime) && Objects.equals(stopBy, that.stopBy) && Objects.equals(lastReloadTime, that.lastReloadTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appName, numberOfThread, numberOfRow, status, lastStartTime, lastStopTime, stopBy, dataReload, lastReloadTime);
    }
}
