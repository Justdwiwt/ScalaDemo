package leetCode._2800

object Solution_2790 {
  def maxIncreasingGroups(usageLimits: List[Int]): Int = {
    val sorted = usageLimits.sorted
    var available = 0L
    var group = 0
    sorted.foreach(u => {
      available += u
      if (available > group) {
        group += 1
        available -= group
      }
    })
    group
  }
}
