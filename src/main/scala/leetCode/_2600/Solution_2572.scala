package leetCode._2600

import scala.collection.mutable

object Solution_2572 {
  def squareFreeSubsets(nums: Array[Int]): Int = {
    val M = 1000000007
    val st1 = Set[Int](4, 8, 12, 16, 20, 24, 28, 9, 18, 27, 16, 25)
    var st2 = Set[Int](2, 3, 5, 6, 7, 10, 11, 13, 14, 15, 17, 19, 21, 22, 23, 26, 29, 30)
    val m1: Map[Int, Set[Int]] = Map(
      1 -> Set(),
      2 -> Set(2, 6, 10, 14, 22, 26, 30),
      3 -> Set(3, 6, 15, 21, 30),
      5 -> Set(5, 10, 15, 30),
      6 -> Set(2, 6, 10, 14, 22, 26, 30, 3, 15, 21),
      7 -> Set(7, 14, 21),
      10 -> Set(2, 6, 10, 14, 22, 26, 30, 5, 15),
      11 -> Set(11, 22),
      13 -> Set(13, 26),
      14 -> Set(2, 6, 10, 14, 22, 26, 30, 7, 21),
      15 -> Set(3, 6, 15, 21, 30, 5, 10),
      17 -> Set(17),
      19 -> Set(19),
      21 -> Set(3, 6, 15, 21, 30, 7, 14),
      22 -> Set(2, 6, 10, 14, 22, 26, 30, 11),
      23 -> Set(23),
      26 -> Set(2, 6, 10, 14, 22, 26, 30, 13),
      29 -> Set(29),
      30 -> Set(2, 6, 10, 14, 22, 26, 30, 3, 15, 21, 5)
    )
    val m2 = nums.filter(!st1.contains(_)).groupBy(f => f).map(line => (line._1, line._2.length.toLong))
    val sorted = m2.keySet.toArray.filter(_ != 1).sorted
    st2 = st2.intersect(sorted.toSet)
    var res = BigDecimal.apply(0)
    sorted.indices.foreach(i => {
      var buffer = mutable.Buffer.empty[Array[Int]]
      val base = sorted(i)
      buffer.append(Array(base))
      res = res + m2(base)
      while (buffer.nonEmpty) {
        val cur = mutable.Buffer.empty[Array[Int]]
        buffer.foreach(baseArr => {
          val chose = st2.diff(baseArr.map(line => m1(line)).reduce(_.++(_))).filter(_ > baseArr.last)
          if (chose.nonEmpty) {
            chose.foreach(choseNum => {
              val curArr = baseArr ++ Array(choseNum)
              cur.append(curArr)
              res = res + curArr.map(line => BigDecimal.apply(m2.getOrElse(line, 1L))).product
            })
          }
        })
        buffer = cur
      }
    })
    res = (res + 1) * BigDecimal.apply(2).pow(m2.getOrElse(1, 0L).toInt) - 1
    if (res > M) res = res % M
    res.toInt
  }
}
