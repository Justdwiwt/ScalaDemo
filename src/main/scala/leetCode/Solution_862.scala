package leetCode

object Solution_862 {
  def shortestSubarray(A: Array[Int], K: Int): Int = {
    val t = A.indices.withFilter(i => A(i) > 0).map(i => func(i, A, K))
    if (t.exists(_ > 0)) t.filter(_ > 0).min else -1
  }

  def func(start: Int, A: Array[Int], K: Int): Int = {
    var cnt = 0
    var t = K
    (start until A.length).foreach(i => {
      t = t - A(i)
      cnt = cnt + 1
      if (t <= 0) return cnt
    })
    -1
  }
}
