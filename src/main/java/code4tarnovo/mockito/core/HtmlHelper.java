package code4tarnovo.mockito.core;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MartinMilev
 *         <martinmariusmilev@gmail.com>
 */
public class HtmlHelper {
    private Map<String,String> values = new HashMap<String,String>();
    private String html;

    public HtmlHelper(String html) {
        this.html = html;
    }

    public void setValue(String placeholder, String value) {
        values.put(placeholder,value);
    }

    public String evaluate() {
        String result = html;
        for (String placeHolder : values.keySet()) {
            result = result.replaceAll("\\{\\{" + placeHolder + "\\}\\}", values.get(placeHolder));
        }

        return result;
    }
}
