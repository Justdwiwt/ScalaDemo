package leetCode

object Solution_1652 {
  def decrypt(code: Array[Int], k: Int): Array[Int] = {
    val res = Array.ofDim[Int](code.length)
    code.indices.foreach(i => if (k > 0) {
      var sum = 0
      (1 to k).foreach(j => sum += code((i + j + code.length) % code.length))
      res(i) = sum
    } else if (k < 0) {
      var sum = 0
      (1 to -k).foreach(j => sum += code((i - j + code.length) % code.length))
      res(i) = sum
    } else res(i) = 0)
    res
  }
}
