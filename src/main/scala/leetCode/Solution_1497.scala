package leetCode

object Solution_1497 {
  def canArrange(arr: Array[Int], k: Int): Boolean = {
    val A = Array.fill(k)(0)
    arr.foreach(v => {
      var t = v % k
      if (t < 0) t += k
      A(t) += 1
    })
    if (A(0) % 2 != 0) return false
    (1 to k / 2).foreach(i => if (!(A(i) == A(k - i))) return false)
    true
  }
}
