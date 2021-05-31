package com.Artttdez.PastebinApi.pastebin;

import com.Artttdez.PastebinApi.paste.Paste;
import com.Artttdez.PastebinApi.response.Response;
import org.jetbrains.annotations.NotNull;

public interface Pastebin {
    @NotNull
    Response post(Paste paste);
}
