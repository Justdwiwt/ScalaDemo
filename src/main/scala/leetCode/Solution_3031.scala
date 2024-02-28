package leetCode

object Solution_3031 {
  def minimumTimeToInitialState(word: String, k: Int): Int = {
    val s = word.toCharArray
    val n = s.length
    val z = Array.fill(n)(0)
    var l = 0
    var r = 0
    s.indices.drop(1).foreach(i => {
      if (i <= r) z(i) = z(i - l).min(r - i + 1)
      while (i + z(i) < n && s(z(i)) == s(i + z(i))) {
        l = i
        r = i + z(i)
        z(i) += 1
      }
      if (i % k == 0 && z(i) >= n - i) return i / k
    })
    (n - 1) / k + 1
  }
}
