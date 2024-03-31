package leetCode._1000

object Solution_935 {
  private def nextStep(num: Int): List[Int] = num match {
    case 1 => List(6, 8)
    case 2 => List(7, 9)
    case 3 => List(4, 8)
    case 4 => List(0, 3, 9)
    case 5 => List.empty
    case 6 => List(0, 1, 7)
    case 7 => List(2, 6)
    case 8 => List(1, 3)
    case 9 => List(2, 4)
    case 0 => List(4, 6)
  }

  def knightDialer(n: Int): Int = {
    @scala.annotation.tailrec
    def getPossibilities(nums: List[(Int, Int)], n: Int): Int = {
      if (n <= 0) nums.map(_._2).reduce((a, b) => (a + b) % 1000000007)
      else {
        val upd = nums
          .flatMap { case (num, count) => nextStep(num).map((_, count)) }
          .groupBy(_._1)
          .map { case (num, occ) => (num, occ.map(_._2).reduce((a, b) => (a + b) % 1000000007)) }
          .toList
        getPossibilities(upd, n - 1)
      }
    }

    val init = (0 to 9).map((_, 1)).toList
    getPossibilities(init, n - 1)
  }
}
