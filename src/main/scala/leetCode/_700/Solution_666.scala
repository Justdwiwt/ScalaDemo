package leetCode._700

object Solution_666 {
  def pathSum(nums: Array[Int]): Int = {
    if (nums.isEmpty) return 0
    val map = nums.map(num => {
      val depth = num / 100
      val pos = num / 10 % 10
      val value = num % 10
      val code = math.pow(2, depth - 1).toInt + pos - 1
      code -> value
    }).toMap

    def f(map: Map[Int, Int], idx: Int, curVal: Int): Int = map.get(idx) match {
      case None => 0
      case Some(value) =>
        val newCurVal = curVal + value
        val left = idx * 2
        val right = idx * 2 + 1
        if (!map.contains(left) && !map.contains(right)) newCurVal
        else f(map, left, newCurVal) + f(map, right, newCurVal)
    }

    f(map, 1, 0)
  }
}
