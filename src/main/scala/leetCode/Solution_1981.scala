package leetCode

object Solution_1981 {
  def minimizeTheDifference(mat: Array[Array[Int]], target: Int): Int = {
    val dp = Array.fill(mat.length + 1, 6401)(false)
    dp.head(0) = true
    (1 to mat.length).foreach(i => (0 to 6400).foreach(p =>
      if (dp(i - 1)(p))
        mat(i - 1).foreach(cur => dp(i)(p + cur) = true)
    ))
    var res = Int.MaxValue
    (0 to 6400).foreach(v => if (dp(mat.length)(v) && (target - v).abs < res) res = (target - v).abs)
    res
  }
}
