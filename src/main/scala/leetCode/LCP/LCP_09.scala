package leetCode.LCP

object LCP_09 {
  def minJump(jump: Array[Int]): Int = {
    val dp = Array.fill(jump.length)(0)
    (jump.length - 1 to 0 by (-1)).foreach(i => {
      if (i + jump(i) >= jump.length) dp(i) = 1
      else dp(i) = dp(i + jump(i)) + 1
      var j = i + 1
      while (j < jump.length && j < i + jump(i) && dp(j) > dp(i)) {
        dp(j) = dp(i) + 1
        j += 1
      }
    })
    dp(0)
  }
}
