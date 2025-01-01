package leetCode._3400

object Solution_3321 {
  def findXSum(nums: Array[Int], k: Int, x: Int): Array[Long] = {
    val L = collection.mutable.TreeSet.empty[(Int, Int)](Ordering.by[(Int, Int), (Int, Int)](t => (t._1, t._2)))
    val R = collection.mutable.TreeSet.empty[(Int, Int)](L.ordering)
    val cnt = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    var sumL = 0L

    def add(value: Int): Unit = {
      val count = cnt(value)
      if (count == 0) return
      val pair = (count, value)
      if (L.nonEmpty && L.ordering.compare(pair, L.head) > 0) {
        sumL += pair._1.toLong * pair._2
        L.add(pair)
      } else R.add(pair)
    }

    def delete(value: Int): Unit = {
      val count = cnt.getOrElse(value, 0)
      if (count == 0) return
      val pair = (count, value)
      if (L.contains(pair)) {
        sumL -= pair._1.toLong * pair._2
        L.remove(pair)
      } else R.remove(pair)
    }

    def l2r(): Unit = {
      val pair = L.head
      L.remove(pair)
      sumL -= pair._1.toLong * pair._2
      R.add(pair)
    }

    def r2l(): Unit = {
      val pair = R.last
      R.remove(pair)
      sumL += pair._1.toLong * pair._2
      L.add(pair)
    }

    val res = Array.fill(nums.length - k + 1)(0L)
    nums.indices.foreach(r => {
      val in = nums(r)
      delete(in)
      cnt(in) += 1
      add(in)
      val l = r + 1 - k
      if (l >= 0) {
        while (R.nonEmpty && L.size < x) r2l()
        while (L.size > x) l2r()
        res(l) = sumL
        val out = nums(l)
        delete(out)
        cnt(out) -= 1
        add(out)
      }
    })
    res
  }
}
