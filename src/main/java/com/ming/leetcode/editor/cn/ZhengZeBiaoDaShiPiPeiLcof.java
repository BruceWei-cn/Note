package com.ming.leetcode.editor.cn;

//请设计一个程序来支持用户在文本编辑器中的模糊搜索功能。用户输入内容中可能使用到如下两种通配符：
//
// 
// '.' 匹配任意单个字符。 
// '*' 匹配零个或多个前面的那一个元素。 
// 
//
// 
//
// 请返回用户输入内容 input 所有字符是否可以匹配原文字符串 article。 
//
// 
//
// 示例 1: 
//
// 
//输入: article = "aa", input = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入: article = "aa", input = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 
//输入: article = "ab", input = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= article.length <= 20 
// 1 <= input.length <= 20 
// article 只包含从 a-z 的小写字母。 
// input 只包含从 a-z 的小写字母，以及字符 . 和 * 。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
//
// 
//
// 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
// 
//
// 
//
// Related Topics 递归 字符串 动态规划 👍 572 👎 0


public class ZhengZeBiaoDaShiPiPeiLcof {
    public static void main(String[] args) {
        Solution solution = new ZhengZeBiaoDaShiPiPeiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean articleMatch(String s, String p) {

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}