package leetCode._3300

object Solution_3205 {
  def maxScore(nums: Array[Int]): Int = {
    def f(i: Int, memo: Map[Int, Int]): (Int, Map[Int, Int]) = {
      if (i == nums.length) return (0, memo)
      memo.get(i) match {
        case Some(res) => (res, memo)
        case None =>
          val (res, updatedMemo) = (i + 1 until nums.length).foldLeft((0, memo)) {
            case ((maxRes, currMemo), j) =>
              val (score, newMemo) = f(j, currMemo)
              (maxRes.max(score + (j - i) * nums(j)), newMemo)
          }
          (res, updatedMemo + (i -> res))
      }
    }

    f(0, Map.empty)._1
  }
}
