package hr.ja.myhttp.demo;

import hr.ja.myhttp.form.Form;
import hr.ja.myhttp.form.FormUtil;
import hr.ja.myhttp.form.TextField;
import lombok.Getter;
import lombok.Setter;

@Form()
@Getter
@Setter
public class UserForm {

    @TextField(label = "Name")
    private String name = "Default name...";

    @TextField(label = "Age")
    private String age ;

//    @Override
//    public String toString() {
//        return FormUtil.toForm(this);
//    }
}
