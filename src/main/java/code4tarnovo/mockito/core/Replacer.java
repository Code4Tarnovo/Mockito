package code4tarnovo.mockito.core;

/**
 * @author MartinMilev
 *         <martinmariusmilev@gmail.com>
 */
public interface Replacer {

    public void setValue(String placeholder, String value);

    public String evaluate();
}
