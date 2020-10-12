package hr.ja.myhttp.form;

import hr.ja.myhttp.gui.Widget;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
public class TextFieldWidget extends Widget {

    private String label;
    private String value;
    private String idName;

    public TextFieldWidget(String label, String value, String idName) {

        this.label = label;
        this.value = StringUtils.trimToEmpty(value);
        this.idName = idName;

        //language=InjectedFreeMarker
        setTemplate("""
                  <div class="form-group">
                    <label for="${idName}">${label}</label>
                    <input type="text" class="form-control" id="${idName}" name='${idName}' value='${value}'>
                  </div>
                """);
    }
}
