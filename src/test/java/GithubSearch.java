
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;


public class GithubSearch {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy="eager";

         Configuration.holdBrowserOpen = true;
    }

@Test
    void findSelenideAndJunit(){
    open("https://github.com/selenide/selenide");
    $("#wiki-tab").click();

    $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
    $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
    $(byText("SoftAssertions")).click();

    $("#repo-content-pjax-container").shouldHave(text("class Tests {\n" +
            "  @RegisterExtension \n" +
            "  static SoftAssertsExtension softAsserts = new SoftAssertsExtension();\n" +
            "\n" +
            "  @Test\n" +
            "  void test() {\n" +
            "    Configuration.assertionMode = SOFT;\n" +
            "    open(\"page.html\");\n" +
            "\n" +
            "    $(\"#first\").should(visible).click();\n" +
            "    $(\"#second\").should(visible).click();\n" +
            "  }\n" +
            "}"));
}

}
