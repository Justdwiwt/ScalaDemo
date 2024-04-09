package leetCode._100

object Solution_1 {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    @scala.annotation.tailrec
    def f(needed: Map[Int, Int], cur: Int): Array[Int] = {
      val n = nums(cur)
      needed.get(n) match {
        case Some(idx) => Array(idx, cur)
        case None => f(needed + (target - n -> cur), cur + 1)
      }
    }

    f(Map(), 0)
  }
}
