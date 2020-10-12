package hr.ja.myhttp.util;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import hr.ja.myhttp.gui.Widget;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.StringWriter;
import java.io.Writer;

@Slf4j
public class TemplateParser {

    private static TemplateParser instance = new TemplateParser();
    private StringTemplateLoader templateLoader = new StringTemplateLoader();
    private Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);


    public TemplateParser() {
        cfg.setTemplateLoader(templateLoader);
    }

    public static String parseWidget(Widget w) {
        String templateID = TemplateHolder.getTemplateId(w);
        String template = TemplateHolder.getTemplate(w);
        return instance.parse(template, w, templateID);
    }

    public static String parsePage(Page page) {
        String template = TemplateHolder.getTemplate(page);
        return instance.parse(template, page, TemplateHolder.getTemplateId(page));
    }

    public static void main(String[] args) {
        TemplateParser parser = new TemplateParser();
    }

    @SneakyThrows
    public String parse(String template, Object model, String templateId) {
        if (templateLoader.findTemplateSource(templateId) == null)
            templateLoader.putTemplate(templateId, template);

        Template t = cfg.getTemplate(templateId);
        Writer out = new StringWriter();
        t.process(model, out);
        return out.toString();
    }
}