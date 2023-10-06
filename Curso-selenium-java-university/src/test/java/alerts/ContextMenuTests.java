package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

public class ContextMenuTests extends BaseTests {

    @Test
    public void contextMenuAlerts(){
        ContextMenuPage contextmenu = homePage.clickContextMenu();
        contextmenu.click_ContextMenuAlert();
        String text = contextmenu.getPopUpText();
        contextmenu.acceptPopUp();
        Assert.assertEquals(text,"You selected a context menu","incorrect message" );
    }
}
