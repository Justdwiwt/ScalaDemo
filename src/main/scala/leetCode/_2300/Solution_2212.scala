package leetCode._2300

object Solution_2212 {
  def maximumBobPoints(numArrows: Int, aliceArrows: Array[Int]): Array[Int] = {
    def f(mask: Long): (Int, Array[Int]) = {
      var n = numArrows
      val arr = Array.fill[Int](12)(0)
      var score = 0
      (0 until 12).foreach(k => {
        if (((mask >> k) & 1) == 1) {
          val need = aliceArrows(k) + 1
          if (n < need) return (0, Array())
          score += k
          arr(k) = need
          n -= need
        }
      })
      arr(0) += n
      (score, arr)
    }

    (0 until 1 << 12).map(mask => f(mask)).maxBy(_._1)._2
  }
}
