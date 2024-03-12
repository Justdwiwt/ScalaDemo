package leetCode._1800

object Solution_1781 {
  def beautySum(s: String): Int = s.indices./:(0)((sum, i) => {
    val arr = Array.fill(26)(0)
    (i until s.length)./:(0)((temp, j) => {
      arr(s.charAt(j) - 'a') += 1
      val beauty = arr.max - arr.filter(_ != 0).min
      temp + beauty
    }) + sum
  })
}
