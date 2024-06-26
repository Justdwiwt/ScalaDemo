package leetCode._800

object Solution_719 {
  def smallestDistancePair(nums: Array[Int], k: Int): Int = {
    val cnt = Array.fill(1000000)(0)
    nums.indices.foreach(i => (i + 1 until nums.length).foreach(j => cnt((nums(i) - nums(j)).abs) += 1))
    var t = k
    var res = -1
    cnt.indices.find(i => {
      if (cnt(i) >= t) {
        res = i
        true
      } else {
        t -= cnt(i)
        false
      }
    })
    res
  }
}
