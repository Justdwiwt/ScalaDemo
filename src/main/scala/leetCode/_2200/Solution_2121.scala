package leetCode._2200

object Solution_2121 {
  def getDistances(arr: Array[Int]): Array[Long] = {
    val tmp = arr.zipWithIndex.groupBy(_._1).mapValues(_.map(_._2.toLong))
    val res = Array.fill(arr.length)(0L)
    tmp.foreach({ case (_, v) =>
      val l = v.scanLeft(0L)(_ + _)
      val r = v.reverse.scanLeft(0L)(_ + _).reverse
      v.indices.foreach(idx => {
        val leftSum = (idx * v(idx) - l(idx)).abs
        val rightSum = ((v.length - idx - 1) * v(idx) - r(idx + 1)).abs
        val sum: Long = leftSum + rightSum
        res(v(idx).toInt) = sum
      })
    })
    res
  }
}
