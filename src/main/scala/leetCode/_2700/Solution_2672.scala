package leetCode._2700

import scala.collection.mutable.ListBuffer

object Solution_2672 {
  def colorTheArray(n: Int, queries: Array[Array[Int]]): Array[Int] = {
    val res = ListBuffer.empty[Int]
    val nums = Array.fill(n)(0)
    var count = 0
    queries.foreach(q => {
      val i = q.head
      val value = q(1)
      if (nums(i) != 0 && i - 1 >= 0 && nums(i - 1) == nums(i)) count -= 1
      if (nums(i) != 0 && i + 1 < n && nums(i + 1) == nums(i)) count -= 1
      nums(i) = value
      if (i - 1 >= 0 && nums(i - 1) == nums(i)) count += 1
      if (i + 1 < n && nums(i + 1) == nums(i)) count += 1
      res.append(count)
    })
    res.toArray
  }
}
