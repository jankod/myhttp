package hr.ja.myhttp.gui;

import lombok.Getter;
import org.intellij.lang.annotations.Language;

import java.util.List;


@SuppressWarnings("TextBlockBackwardMigration")
public class Breadcrumb extends Widget {

    @Getter
    private List<BreadcrumbItem> items;


    public Breadcrumb() {
        @Language("InjectedFreeMarker")
        var html = """
                      <b style='font-size: 22px'>
                        ${items.add('dsfdf')}
                      </b>
                """;
        setTemplate(html);
    }

    public Breadcrumb add(String home, Class<? extends Page> page) {
        items.add(new BreadcrumbItem(home, page));
        return this;

    }

    public Breadcrumb add(String label, Class<? extends Page> page, String icon) {
        items.add(new BreadcrumbItem(label, page, icon));
        return this;
    }

    public Breadcrumb addLabelActive(String label) {
        BreadcrumbItem item = new BreadcrumbItem(label);
        item.setActive(true);
        items.add(item);
        return this;
    }

    public String render() {
        String html = """
                <ol class="breadcrumb float-sm-right">
                <#list items as item>
                     ${item}     
                </#list>
                 </ol>
                """;
        return html;
    }


}
