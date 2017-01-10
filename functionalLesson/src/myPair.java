import java.util.AbstractMap;

/**
 * Created by vadim on 13.12.16.
 */
public class myPair<V, R> //extends AbstractMap.SimpleImmutableEntry
{
    public V fst;
    public R snd;

    myPair(V v, R r)
    {
        fst = v;
        snd = r;
    }
}
