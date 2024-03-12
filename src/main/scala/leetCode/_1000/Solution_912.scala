package leetCode._1000

object Solution_912 {
  def sortArray(nums: Array[Int]): Array[Int] =
    collection.mutable.PriorityQueue(nums: _*)(Ordering.by(-_)).dequeueAll.toArray
}
