package com.Artttdez.PastebinApi.paste;

import com.sun.istack.Nullable;
import org.jetbrains.annotations.NotNull;

public class PasteImpl implements Paste {
    @NotNull
    private final String pasteCode;

    public static PasteImpl createSimplePaste(@NotNull String pasteCode) {
        return new PasteImpl(pasteCode);
    }

    private PasteImpl(@NotNull String pasteCode) {
        this.pasteCode = pasteCode;
    }

    @Override
    public @NotNull String getPasteCode() {
        return pasteCode;
    }

}
