package leetCode._400

object Solution_347 {
  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = nums
    .groupBy(x => x)
    .map({ case (k, v) => List(v.length, k) })
    .toArray
    .sortBy(x => -x.head)
    .map(x => x(1))
    .take(k)
}
