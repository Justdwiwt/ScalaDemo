package leetCode

object Solution_989 {
  def addToArrayForm(A: Array[Int], K: Int): List[Int] = {
    var res = List[Int]()
    var k = K
    val carry = A.reverse.foldLeft(0)((sum, x) => {
      val t = k % 10 + x + sum
      k = k / 10
      res :::= List(t % 10)
      t / 10
    })
    if (k == 0) {
      if (carry == 1) res :::= List(1)
      res
    } else {
      k = k + carry
      while (k > 0) {
        res :::= List(k % 10)
        k = k / 10
      }
      res
    }
  }
}
