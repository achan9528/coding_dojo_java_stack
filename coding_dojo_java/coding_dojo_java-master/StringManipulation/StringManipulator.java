public class StringManipulator{
    public String trimAndConcat(String str1, String str2){
        str1 = str1.trim();
        str2 = str2.trim();
        return str1.concat(str2);
    }

    public Integer getIndexOrNull(String str, char c){
        if (str.indexOf(c) == -1){
            return null;
        }
        return str.indexOf(c);
    }

    public Integer getIndexOrNull(String str1, String str2){
        if (str1.indexOf(str2) == -1){
            return null;
        }
        return str1.indexOf(str2);
    }

    public String concatSubstring(String str1, int start, int end, String str2){
        str1 = str1.substring(1,2);
        return str1.concat(str2);
    }
}