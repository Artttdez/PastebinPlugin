package com.Artttdez.pastebinsender.storage;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(name = "com.Artttdez.pastebinsender.storage",
        storages = {@Storage("Setting.xml")})
public class SettingState implements PersistentStateComponent<SettingState> {
    private String devKey = "";

    public static SettingState getInstance() {
        return ServiceManager.getService(SettingState.class);
    }

    @Override
    public @Nullable SettingState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull SettingState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public String getDevKey() {
        return devKey;
    }

    public void setDevKey(String devKey) {
        this.devKey = devKey;
    }
}
