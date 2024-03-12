package leetCode._600

import scala.collection.mutable
import scala.util.Random

object Solution_519 {

  class Solution_519(_n_rows: Int, _n_cols: Int) {

    private val row = _n_rows
    private val col = _n_cols
    private var n = row * col
    private var m = mutable.HashMap.empty[Int, Int]
    private val random = new Random()

    def flip(): Array[Int] = {
      if (n < 0) return null
      val r = random.nextInt(n)
      n -= 1
      val x = m.getOrElse(r, r)
      m += r -> m.getOrElse(n, n)
      Array(x / col, x % col)
    }

    def reset() {
      m = mutable.HashMap.empty[Int, Int]
      n = row * col
    }

  }

}
