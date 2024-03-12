package leetCode.offer

object XH_1_3 {
  def array_interval_sum(nums: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    var res = Array.empty[Int]
    queries.indices.foreach(i => {
      val p = (queries(i)(0), queries(i)(1))
      var sum = 0
      (p._1 to p._2).foreach(v => {
        var t = nums(v - 1)
        sum += t
      })
      res :+= sum
    })
    res
  }
}
