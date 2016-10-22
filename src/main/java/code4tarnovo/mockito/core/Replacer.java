package code4tarnovo.mockito.core;

/**
 * Created by zumba on 22.10.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */
public interface Replacer {

    public void setValue(String placeholder, String value);

    public String evaluate();
}
