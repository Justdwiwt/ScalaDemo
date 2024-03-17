package leetCode._2400

object Solution_2370 {
  def longestIdealString(s: String, k: Int): Int = s
    .foldLeft(Array.ofDim[Int](100))((acc, cur) => {
      acc(cur - 'a') = (0.max(cur - 'a' - k) to cur - 'a' + k).map(acc).max + 1
      acc
    })
    .max
}
