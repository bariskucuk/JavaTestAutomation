package com.sociotestautomation.pages.plannerside;
import com.sociotestautomation.base.Browser;
import org.openqa.selenium.support.PageFactory;
import java.util.function.Supplier;

public class PlannerPages {
    private static<T> T getPage(Supplier<T> construct) {
        T t = construct.get();
        PageFactory.initElements(Browser.driver, t);
        return t;
    }
    public static LogInPage logInPage() {
        return getPage(LogInPage::new);
    }

    public static ManageEventPage manageEventPage() {
        return getPage(ManageEventPage::new);
    }

    public static MyEventsPage myEventsPage() {
        return getPage(MyEventsPage::new);
    }

    public static SignUpPage singUpPage() {
        return getPage(SignUpPage::new);
    }

    public static WebAppPage webAppPage() {
        return getPage(WebAppPage::new);
    }

    public static FeaturesPage featuresPage() {
        return getPage(FeaturesPage::new);
    }
}
