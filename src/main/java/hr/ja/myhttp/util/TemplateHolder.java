package hr.ja.myhttp.util;

import hr.ja.myhttp.gui.Widget;
import lombok.Singular;

import java.util.HashMap;

public class TemplateHolder {

    private static HashMap<String, String> templates = new HashMap<>();

    public static void setTemplate(Widget widget, String template) {
        templates.put(getTemplateId(widget), template);
    }

    public static String getTemplate(Widget widget) {
        return templates.get(getTemplateId(widget));
    }

    public static String getTemplateId(Object o) {
        return o.getClass().getCanonicalName();
    }
}
