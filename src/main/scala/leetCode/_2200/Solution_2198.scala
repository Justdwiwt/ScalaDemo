package leetCode._2200

object Solution_2198 {
  def singleDivisorTriplet(nums: Array[Int]): Long = {
    val counter = nums.groupBy(identity).mapValues(_.length).map { case (x, y) => (BigInt(x), BigInt(y)) }
    var res = BigInt(0)

    counter.keys.foreach(n1 => counter.keys.foreach(n2 => counter.keys
      .withFilter(n3 => n1 <= n2 && n2 <= n3)
      .foreach(n3 => {
        val sum = n1 + n2 + n3
        val divisorsCount = List(n1, n2, n3).count(sum % _ == 0)
        if (divisorsCount == 1) {
          val good1 = List(n1, n2, n3).find(sum % _ == 0).get
          val bad = List(n1, n2, n3).filterNot(_ == good1)
          if (bad.head == bad(1)) res += counter(good1) * counter(bad.head) * (counter(bad.head) - 1) * 3
          else res += counter(good1) * counter(bad.head) * counter(bad(1)) * 6
        }
      })))
    res.toLong
  }
}
