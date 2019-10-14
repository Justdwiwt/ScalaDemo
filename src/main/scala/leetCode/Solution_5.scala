package leetCode

object Solution_5 {
  def longestPalindrome(s: String): String = {
    //奇数的回文串
    var result1 = ""
    var left1 = 0
    var right1 = 0
    var step1 = 0
    var flag1 = true
    //偶数的回文串
    var result2 = ""
    var left2 = 0
    var step2 = 0
    var right2 = 0
    var flag2 = true
    val indices = s.indices
    //暴力穷举
    for (i <- indices) {
      step1 = 0
      flag1 = true
      while (flag1) {
        step1 += 1
        left1 = i - step1
        right1 = i + step1
        flag1 = indices.contains(left1) && indices.contains(right1) && s(left1) == s(right1)
        if (!flag1) {
          val resultTmp = s.substring(left1 + 1, right1)
          if (resultTmp.length > result1.length)
            result1 = resultTmp
        }
      }
      step2 = 0
      flag2 = true
      while (flag2) {
        left2 = i - step2
        right2 = i + step2 + 1
        step2 += 1
        flag2 = indices.contains(left2) && indices.contains(right2) && s(left2) == s(right2)
        if (!flag2) {
          val resultTmp2 = s.substring(left2 + 1, right2)
          if (resultTmp2.length > result2.length)
            result2 = resultTmp2
        }
      }
    }
    if (result1.length >= result2.length) result1
    else result2
  }
}
