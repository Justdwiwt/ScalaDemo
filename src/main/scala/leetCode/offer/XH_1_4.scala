package leetCode.offer

object XH_1_4 {
  def array_interval_std(nums: Array[Int], queries: Array[Array[Int]]): Array[Double] = {
    var res = Array.empty[Double]
    queries.indices.foreach(i => {
      val p = (queries(i)(0), queries(i)(1))
      val len = (p._1 to p._2).length
      var arr = Array.emptyDoubleArray
      (p._1 to p._2).foreach(v => arr :+= nums(v - 1).toDouble)
      val sum = arr.sum
      val dAve = sum / len
      var dVar = 0.0
      arr.indices.foreach(v => dVar += ((arr(v) - dAve) * (arr(v) - dAve)))
      res :+= (dVar / len)
    })
    res
  }
}
