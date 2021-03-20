package com.clpstraining.constants;

public enum ConstantCodes {
    HTTP_CODE("404");

    private String value;

    ConstantCodes(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
