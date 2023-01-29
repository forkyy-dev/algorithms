package leetcode.easy;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while(start < end){
            int mid = start + (end-start)/2;
//            if(!isBadVersion(mid)){
//                start = mid+1;
//            }else{
//                end = mid;
//            }
        }
        return start;
    }
}


//mid 값을 (end-start) / 2로 하면 int의 범위를 벗어나기 때문에 start + (end-start) / 2 로 해야한다.