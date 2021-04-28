package datastruct.sort;

/**
 * @version 1.0
 * @package datastruct.sort
 * @Author kirain
 * @create 2021/4/28 0:15
 * @description
 */
public interface Sort {
    public  <T extends Comparable<T>> T[] sort(T[] array);
}
