package leetCode

object Solution_2195 {
  def minimalKSum(nums: Array[Int], k: Int): Long = {
    var res = ((1 + k) * 1L * k) / 2
    val sorted = nums.distinct.sorted
    var t = k
    sorted
      .withFilter(x => x <= t)
      .foreach(x => {
        res -= x
        t += 1
        res += t
      })
    res
  }
}
