package datastruct.sort;

/**
 * @version 1.0
 * @package datastruct.sort
 * @Author kirain
 * @create 2021/4/28 8:46
 * @description 实现选择排序
 */
public class SelectSort implements Sort{

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int l = array.length;
        T tmp;
        for(int i = 0; i <  l; i++){
            int flag = i;
            for(int j = i + 1; j < l; j++){
                if(array[j].compareTo(array[flag]) < 0)
                    flag = j;
            }
            tmp = array[i];
            array[i] = array[flag];
            array[flag] = tmp;
        }
        return array;
    }
}
