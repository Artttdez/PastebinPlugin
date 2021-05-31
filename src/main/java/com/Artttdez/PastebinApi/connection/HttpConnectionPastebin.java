package com.Artttdez.PastebinApi.connection;

import com.Artttdez.PastebinApi.response.Response;

public interface HttpConnectionPastebin {
    void Add(String key, String value);
    void Remove(String key);
    Response post();
}
