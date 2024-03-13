package leetCode._3000

import scala.math.Integral.Implicits._

object Solution_2910 {
  def minGroupsForValidAssignment(nums: Array[Int]): Int = {
    val group = nums.groupBy(identity).mapValues(_.length).values

    def split(minGroupsCandidate: Int): Int = group.map(size => {
      val (numGroups, rem) = size /% minGroupsCandidate
      if (rem > numGroups) 100000
      else (size.toFloat / (minGroupsCandidate + 1)).ceil.toInt
    }).sum

    if (group.size == 1) 1
    else (1 to group.min).map(split).min
  }
}
