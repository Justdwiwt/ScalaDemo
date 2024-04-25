package leetCode._2100

object Solution_2098 {
  def largestEvenSum(nums: Array[Int], k: Int): Long = {
    val oddNums = new java.util.PriorityQueue[Int]((a: Int, b: Int) => b - a)
    val evenNums = new java.util.PriorityQueue[Int]((a: Int, b: Int) => b - a)
    nums.foreach(num => if (num % 2 == 0) evenNums.add(num) else oddNums.add(num))
    var res = 0L
    var remainingK = k
    if (remainingK % 2 == 1) {
      if (evenNums.isEmpty) return -1
      remainingK -= 1
      res += evenNums.poll()
    }
    var candidate1 = -1
    var candidate2 = -1
    while (remainingK > 0) {
      remainingK -= 2
      if (candidate1 == -1 && oddNums.size >= 2) candidate1 = oddNums.poll() + oddNums.poll()
      if (candidate2 == -1 && evenNums.size >= 2) candidate2 = evenNums.poll() + evenNums.poll()
      if (candidate1 == -1 && candidate2 == -1) return -1
      if (candidate1 < candidate2) {
        res += candidate2
        candidate2 = -1
      } else {
        res += candidate1
        candidate1 = -1
      }
    }
    res
  }
}
