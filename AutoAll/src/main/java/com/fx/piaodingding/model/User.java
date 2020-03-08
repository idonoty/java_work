package com.fx.piaodingding.model;

public class User {
    private int id;
    private String nickname;
    private String mobile;
    private String union_id;
    private int status;
    private int real_status;
    private String create_ip;
    private String create_time;
    private int fail_times;
    private int version;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", union_id='" + union_id + '\'' +
                ", status=" + status +
                ", real_status=" + real_status +
                ", create_ip='" + create_ip + '\'' +
                ", create_time='" + create_time + '\'' +
                ", fail_times=" + fail_times +
                ", version=" + version +
                ", register_source=" + register_source +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUnion_id() {
        return union_id;
    }

    public void setUnion_id(String union_id) {
        this.union_id = union_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getReal_status() {
        return real_status;
    }

    public void setReal_status(int real_status) {
        this.real_status = real_status;
    }

    public String getCreate_ip() {
        return create_ip;
    }

    public void setCreate_ip(String create_ip) {
        this.create_ip = create_ip;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getFail_times() {
        return fail_times;
    }

    public void setFail_times(int fail_times) {
        this.fail_times = fail_times;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getRegister_source() {
        return register_source;
    }

    public void setRegister_source(int register_source) {
        this.register_source = register_source;
    }

    private int register_source;
}
