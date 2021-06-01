package com.Artttdez.pastebinsender.storage;


import com.Artttdez.pastebinsender.gui.SettingsGui;
import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SettingConfiguration implements Configurable {

    private SettingsGui component;

    @Override
    @Nls(capitalization = Nls.Capitalization.Title)
    public String getDisplayName() {
        return "Pastebin Sender Settings";
    }

    @Override
    public @Nullable JComponent createComponent() {
        component = new SettingsGui();
        System.out.println(component.getTextField());
        return component.getPanel();
    }

    @Override
    public boolean isModified() {
        SettingState state = SettingState.getInstance();
        return !(component.getTextField().getText().equals(state.getDevKey()));
    }

    @Override
    public void apply() {
        SettingState state = SettingState.getInstance();
        state.setDevKey(component.getTextField().getText());
    }

    @Override
    public void reset() {
        SettingState state = SettingState.getInstance();
        component.getTextField().setText(state.getDevKey());
    }

    @Override
    public void disposeUIResources() {
        component = null;
    }
}