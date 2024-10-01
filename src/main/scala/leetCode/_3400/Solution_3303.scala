package leetCode._3400

object Solution_3303 {
  private def f(s: String): Array[Int] = {
    val n = s.length
    val arr = Array.fill(n)(0)
    var boxL = 0
    var boxR = 0

    s.indices.drop(1).foreach(i => {
      if (i <= boxR) arr(i) = arr(i - boxL).min(boxR - i + 1)
      while (i + arr(i) < n && s(arr(i)) == s(i + arr(i)))
        arr(i) += 1
      if (i + arr(i) - 1 > boxR) {
        boxL = i
        boxR = i + arr(i) - 1
      }
    })
    arr
  }

  def minStartingIndex(s: String, pattern: String): Int = {
    val preZ = f(pattern + s).drop(pattern.length)
    val sufZ = f(pattern.reverse + s.reverse).drop(pattern.length).reverse
    val n = s.length
    val m = pattern.length

    (0 to n - m).find(i => preZ(i) + sufZ(i + m - 1) >= m - 1) match {
      case Some(index) => index
      case None => -1
    }
  }
}
