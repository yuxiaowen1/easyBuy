package cn.bdqn.utils;


public class StringUtils {
    public static int String2Int(String str,int delVal){
        try {
            if (str == null){
                return delVal;
            }
            return Integer.parseInt(str);
        }catch (Exception e){
            e.printStackTrace();
        }
        return delVal;
    }

}
