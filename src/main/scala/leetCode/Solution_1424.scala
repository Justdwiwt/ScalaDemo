package leetCode

import scala.collection.mutable

object Solution_1424 {
  def findDiagonalOrder(nums: List[List[Int]]): Array[Int] = {
    var cnt = 0
    nums.foreach(i => cnt += i.length)
    val res = Array.fill(cnt)(0)
    var ind = 0
    val q = new mutable.Queue[Array[Int]]()
    q.enqueue(Array(0, 0))
    val s = new mutable.HashSet[String]()
    s.add(0 + "_" + 0)
    while (q.nonEmpty) {
      val t = q.head
      q.dequeue()
      res(ind) = nums(t(0))(t(1))
      ind += 1
      if (t(0) + 1 < nums.length && t(1) < nums(t(0) + 1).length && s.add((t(0) + 1) + "_" + t(1)))
        q.enqueue(Array(t(0) + 1, t(1)))
      if (t(0) < nums.length && t(1) + 1 < nums(t(0)).length && s.add(t(0) + "_" + (t(1) + 1)))
        q.enqueue(Array(t(0), t(1) + 1))
    }
    res
  }
}
