package leetCode

object Solution_1387 {
  def getKth(lo: Int, hi: Int, k: Int): Int = {
    var arr = Array.empty[(Int, Int)]

    def f(input: Int): Int = {
      var res = 0
      var t = input
      while (t != 1) {
        if (t % 2 == 0) t /= 2
        else t = t * 3 + 1
        res += 1
      }
      res
    }

    (lo to hi).foreach(i => arr :+= (f(i), i))
    arr = arr.sorted
    arr(k - 1)._2
  }
}
