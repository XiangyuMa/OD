package array;

/**
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 */
public class SearchMatrix {

    //循环遍历 暴力解法
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i  = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(target == matrix[i][j]){
                    return true;
                }
            }
        }
        return  false;
    }
    //针对每一行元素使用二分查找
    public static boolean searchMatrix2(int[][] matrix, int target) {
        for(int i  = 0;i < matrix.length;i++){
            int[] arr = matrix[i];
            if(search(arr,target)){
                return true;
            }
        }
        return false;
    }

    public static boolean search(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(target < arr[mid]){
                high = mid - 1;
            } else if (target> arr[mid]) {
                low = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }

    //将二维数组映射到一维 直接使用二分查找即可
    public boolean searchMatrix3(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
