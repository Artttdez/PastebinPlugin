import com.Artttdez.PastebinApi.paste.PasteImpl;
import com.Artttdez.PastebinApi.pastebin.Pastebin;
import com.Artttdez.PastebinApi.pastebin.PastebinImpl;
import com.Artttdez.PastebinApi.response.Response;
import com.Artttdez.pastebinsender.storage.SettingState;
import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

public class pasteAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Editor editor = e.getData(PlatformDataKeys.EDITOR);
        String pasteCode = editor.getSelectionModel().getSelectedText();
        String devKey = SettingState.getInstance().getDevKey();
        Pastebin pastebin = new PastebinImpl(devKey);
        if (pasteCode == null) {
            Messages.showMessageDialog("Select some text/code", "Pastebin", Messages.getInformationIcon());
        } else {
            Response result = pastebin.post(PasteImpl.createSimplePaste(pasteCode));
            if (result.isError()) {
                Messages.showMessageDialog("Add correct devKey", "Pastebin", Messages.getInformationIcon());
            } else {
                BrowserUtil.browse(result.get());
            }
        }
    }
}
