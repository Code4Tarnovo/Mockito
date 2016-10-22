package code4tarnovo.mockito.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zumba on 22.10.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
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

}
