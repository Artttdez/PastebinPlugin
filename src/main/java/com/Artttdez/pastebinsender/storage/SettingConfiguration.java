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
        return component.getPanel();
    }

    @Override
    public boolean isModified() {
        TBlockSettingsState state = TBlockSettingsState.getInstance();
        boolean modified = !component.getCamelCaseCheckBox().isSelected() == state.isCamelCase();
        modified |= !component.getKebabCaseCheckBox().isSelected() == state.isKebabCase();
        modified |= !component.getSnakeCaseCheckBox().isSelected() == state.isSnakeCase();
        modified |= !((String) Objects.requireNonNull(component.getLangComboBox().getSelectedItem())).equalsIgnoreCase(state.getDestLang());
        return modified;
    }

    @Override
    public void apply() {
        TBlockSettingsState state = TBlockSettingsState.getInstance();
        state.setCamelCase(component.getCamelCaseCheckBox().isSelected());
        state.setKebabCase(component.getKebabCaseCheckBox().isSelected());
        state.setSnakeCase(component.getSnakeCaseCheckBox().isSelected());
        state.setDestLang((String) component.getLangComboBox().getSelectedItem());
        updateConverter(state);
        updateTranslator(state);
    }

    @Override
    public void reset() {
        TBlockSettingsState state = TBlockSettingsState.getInstance();
        component.getCamelCaseCheckBox().setSelected(state.isCamelCase());
        component.getKebabCaseCheckBox().setSelected(state.isKebabCase());
        component.getSnakeCaseCheckBox().setSelected(state.isSnakeCase());
        component.getLangComboBox().setSelectedItem(state.getDestLang());
        updateConverter(state);
        updateTranslator(state);
    }

    @Override
    public void disposeUIResources() {
        component = null;
    }

}
