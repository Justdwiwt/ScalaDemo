package leetCode._3000

object Solution_2963 {
  def numberOfGoodPartitions(nums: Array[Int]): Int = {
    val reversedMap = nums.zipWithIndex.foldLeft(Map.empty[Int, Int]) {
      case (map, (num, idx)) => map + (num -> idx)
    }

    nums.indices.dropRight(1).foldLeft(1, 0) {
      case ((ans, maxR), i) =>
        val newMaxR = maxR.max(reversedMap(nums(i)))
        if (newMaxR == i) (ans * 2 % 1000000007, newMaxR)
        else (ans, newMaxR)
    }._1
  }
}
