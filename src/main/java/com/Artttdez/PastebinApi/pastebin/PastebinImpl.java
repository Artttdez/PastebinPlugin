package com.Artttdez.PastebinApi.pastebin;

import com.Artttdez.PastebinApi.connection.HttpConnectionPastebinImpl;
import com.Artttdez.PastebinApi.paste.Paste;
import com.Artttdez.PastebinApi.response.Response;
import org.jetbrains.annotations.NotNull;

public class PastebinImpl implements Pastebin{
    private final static String option = "paste";

    @NotNull
    private final String devKey;


    public PastebinImpl(@NotNull String devKey){
        this.devKey = devKey;
    }

    @Override
    public @NotNull Response post(Paste paste) {
        HttpConnectionPastebinImpl connectionPastebin = new HttpConnectionPastebinImpl();
        connectionPastebin.Add(ApiParameters.Option.apiParameter(), option);
        connectionPastebin.Add(ApiParameters.DeveloperKey.apiParameter(), devKey);
        connectionPastebin.Add(ApiParameters.PasteCode.apiParameter(), paste.getPasteCode());
        return connectionPastebin.post();
    }
}
