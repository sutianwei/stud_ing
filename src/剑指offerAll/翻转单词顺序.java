package 剑指offerAll;

public class 翻转单词顺序 {
    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
     * <p>
     */
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].equals("")) {
                continue;
            }
            res.append(strs[i] + " ");
        }
        return res.toString().trim();
    }


//    public String reverseWords2(String s) {
//        //删除首尾空格
//        s.trim();
//
//        int j = s.length() - 1;
//        int i = j;
//
//        StringBuilder res = new StringBuilder();
//        while (i>=0){
//            while (i>0 && s.charAt(i) != ' ' ) {i--;}
//            res.append(s.substring(i+1,j+1) + "");
//        }

//    }
}
