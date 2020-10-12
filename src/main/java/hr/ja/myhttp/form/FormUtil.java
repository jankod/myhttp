package hr.ja.myhttp.form;


import ch.qos.logback.core.joran.util.beans.BeanUtil;
import hr.ja.myhttp.demo.UserForm;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;

@Slf4j
public class FormUtil {
    public static FormWidget toForm(Object o) {
        FormWidget formWidget = new FormWidget();
        try {
            Field[] fields = o.getClass().getDeclaredFields();
            for (Field field : fields) {
                TextField textField = field.getAnnotation(TextField.class);
                if (textField != null) {
                    String label = textField.label();
                    String idName = field.getName();
                    field.setAccessible(true);
                    String value = (String) field.get(o);
                    TextFieldWidget textFieldWidget = new TextFieldWidget(label, value, idName);
                    formWidget.getWidgets().add(textFieldWidget);
                }
            }
        } catch (Exception e) {
            log.error("", e);
        }
        return formWidget;
    }
}
