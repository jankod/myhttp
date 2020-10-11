package hr.ja.myhttp.gui;

import hr.ja.myhttp.util.TemplateHolder;
import hr.ja.myhttp.util.TemplateParser;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Widget {

    public void setTemplate(String template) {
        TemplateHolder.setTemplate(this, template);
    }

    @Override
    public String toString() {
        return TemplateParser.parseWidget(this);
    }
}
