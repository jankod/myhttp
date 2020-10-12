package hr.ja.myhttp.gui.table;

import hr.ja.myhttp.gui.Widget;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableHeader extends Widget {
    private String label;

    public TableHeader(String label) {
        this.label = label;
        //language=InjectedFreeMarker
        setTemplate("""
                <span>${label}</span>
                """);
    }
}
