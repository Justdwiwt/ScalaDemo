package leetCode

object Solution_667 {
  def constructArray(n: Int, k: Int): Array[Int] = {
    val res = Array.fill(n)(0)
    res(0) = 1
    var i = 1
    var t = 1
    var K = k
    (K until 0 by -1).foreach(j => {
      if (t > 0) res(i) = res(i - 1) + j
      else res(i) = res(i - 1) - j
      i += 1
      t ^= 1
    })
    K += 1
    while (i < n) {
      K += 1
      res(i) = K
      i += 1
    }
    res
  }
}
