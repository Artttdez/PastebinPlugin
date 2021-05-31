package com.Artttdez.PastebinApi.paste;

public interface Paste {
    String getPasteCode();
    String getPasteName();
    ExpireDate getExpireDate();
    PasteFormat getPasteFormat();
}