package com.sociotestautomation.pages.attendeeside;
import com.sociotestautomation.base.Browser;
import org.openqa.selenium.support.PageFactory;
import java.util.function.Supplier;

public class AttendeePages {
    private static<T> T getPage(Supplier<T> construct) {
        T t = construct.get();
        PageFactory.initElements(Browser.driver, t);
        return t;
    }
    public static EventPage eventPage() {
        return getPage(EventPage::new);
    }

    public static WallPage wallPage() {
        return getPage(WallPage::new);
    }

    public static WebAppLogInPage webAppLogInPage() {
        return getPage(WebAppLogInPage::new);
    }

}
