package com.Artttdez.PastebinApi.response;

public class FailedResponse implements Response{
    public FailedResponse(String s) {

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
