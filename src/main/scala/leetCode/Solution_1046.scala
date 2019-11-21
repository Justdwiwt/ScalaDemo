package leetCode

object Solution_1046 {
  def lastStoneWeight(A: Array[Int]): Int = {
    var t = 0
    var res = 0
    val q = collection.mutable.PriorityQueue[Int](A: _*)
    while (q.size > 1) {
      t = q.dequeue() - q.dequeue()
      if (t > 0) q.enqueue(t)
    }
    if (q.size == 1) res = q.dequeue
    res
  }
}
