package com.Artttdez.PastebinApi.pastebin;

import com.Artttdez.PastebinApi.paste.Paste;
import com.Artttdez.PastebinApi.response.Response;
import com.Artttdez.PastebinApi.response.ResponseResult;
import org.jetbrains.annotations.NotNull;

public class PastebinImpl implements Pastebin{
    @Override
    public @NotNull Response post(Paste paste) {
        return ResponseResult.success("");
    }
}
