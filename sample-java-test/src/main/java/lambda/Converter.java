package lambda;

/**
 *
 * @author hoppe
 */
interface Converter<F, T> {

    T convert(F from);
}
