package datastruct.sort;

/**
 * @version 1.0
 * @package datastruct.sort
 * @Author kirain
 * @create 2021/4/28 0:19
 * @description 实现冒泡排序
 */
public abstract class BubbleSort implements Sort{

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int l = array.length;
        l -= 1;
        T tmp;
        for(int i = 0; i < l; i++){
            for(int j = 0; j < l - i; j++){
                if(array[j].compareTo(array[j + 1]) > 0){
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }
}
