package leetCode._3400

object Solution_3326 {
  private val MX = 1000001
  private val lpf: Array[Int] = Array.fill(MX)(0)

  init()

  private def init(): Unit =
    (2 until MX).foreach(i => if (lpf(i) == 0) (i until MX by i).foreach(j => if (lpf(j) == 0) lpf(j) = i))

  def minOperations(nums: Array[Int]): Int = {
    val opt = (nums.length - 2 to 0 by -1).foldLeft((0, true))((acc, i) => {
      val (opCount, isPossible) = acc
      if (nums(i) > nums(i + 1)) {
        val newNum = lpf(nums(i))
        if (newNum > nums(i + 1)) (opCount, false)
        else {
          nums(i) = newNum
          (opCount + 1, isPossible)
        }
      } else acc
    })

    if (opt._2) opt._1 else -1
  }
}
