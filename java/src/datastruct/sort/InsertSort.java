package datastruct.sort;

/**
 * @version 1.0
 * @package datastruct.sort
 * @Author kirain
 * @create 2021/4/28 9:08
 * @description 实现插入排序
 */
public class InsertSort implements Sort{

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int l = array.length;
        T tmp;
        int postion;
        for(int i = 1; i < l; i++){
            tmp = array[i];
            postion = i - 1;
            while(postion >= 0 && tmp.compareTo(array[postion]) < 0){
                array[postion + 1] = array[postion];
                postion--;
            }
            array[postion + 1] = tmp;
        }
        return array;
    }
}
