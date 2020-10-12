package hr.ja.myhttp.gui;

import hr.ja.myhttp.util.Page;
import lombok.Data;

@Data
public abstract class MenuBuilder implements JsWork {


    public abstract void create(Menu menu);

    private Class<? extends Page> defaultPage;

    @Override
    public String init() {
        return """
                function init() {
                    adminLte.init();
                }
                """;
    }
}
