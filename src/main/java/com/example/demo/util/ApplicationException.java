package com.example.demo.util;

public class ApplicationException extends Exception {
    String errorMsg;
    Throwable th;
    public ApplicationException(){
        super();
    }
    public ApplicationException(String errorMsg){
        super(errorMsg);
        this.errorMsg=errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Throwable getTh() {
        return th;
    }

    public void setTh(Throwable th) {
        this.th = th;
    }
}
