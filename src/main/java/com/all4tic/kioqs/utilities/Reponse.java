package com.all4tic.kioqs.utilities;

public class Reponse {
    private String code ;
    private String message ;
    private boolean status;
    private Object datas ;

    public Reponse() {
    }

    public Reponse(String code, String message, boolean status, Object datas) {
        this.code = code;
        this.message = message;
        this.status = status;
        this.datas = datas;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "Reponse{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", status=" + status +
                ", datas=" + datas +
                '}';
    }
}
