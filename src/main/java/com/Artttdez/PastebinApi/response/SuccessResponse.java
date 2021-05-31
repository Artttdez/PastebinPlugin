package com.Artttdez.PastebinApi.response;

public class SuccessResponse implements Response{
    public SuccessResponse(String s) {

    }
    @Override
    public boolean isError() {
        return false;
    }

    @Override
    public String get() {
        return null;
    }
}
