package leetCode

object LCP_55 {
  def getMinimumTime(time: Array[Int], fruits: Array[Array[Int]], limit: Int): Int = {
    var res = 0
    fruits.indices.foreach(i => {
      val f0 = time(fruits(i).head)
      val f1 = fruits(i)(1)
      res += f0 * (f1 / limit + (if (f1 % limit == 0) 0 else 1))
    })
    res
  }
}
