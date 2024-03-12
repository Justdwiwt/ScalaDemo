package leetCode._1600

object Solution_1567 {
  def getMaxLen(nums: Array[Int]): Int = {
    var res = 0
    var z = 0
    var f = 0
    nums.foreach(n => {
      if (n == 0) {
        z = 0
        f = 0
      } else if (n > 0) {
        z += 1
        if (f > 0) f += 1
        res = res.max(z)
      } else {
        val t = z
        z = f
        f = t
        f += 1
        if (z > 0) z += 1
        res = res.max(z)
      }
    })
    res
  }
}
