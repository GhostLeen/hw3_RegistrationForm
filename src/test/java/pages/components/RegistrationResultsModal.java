package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {

    private SelenideElement modalFormName = $("#example-modal-sizes-title-lg");

    private SelenideElement modalForm = $(".modal-dialog");

    private SelenideElement formWithResults = $(".table-responsive");

    public final String modal_title_text = "Thanks for submitting the form";

    public void verifyModalAppears() {
        modalForm.should(appear);
        modalFormName.shouldHave(text(modal_title_text));
    }

    public void verifyModalResults(String key, String value) {
        formWithResults.$(byText(key)).parent().shouldHave(text(value));
    }
}