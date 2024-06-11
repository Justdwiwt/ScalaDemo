package leetCode._3200

object Solution_3175 {
  def findWinningPlayer(skills: Array[Int], k: Int): Int = {
    val (mxI, _) = skills.tail.zipWithIndex.foldLeft((0, 0)) { case ((mxI, win), (skill, i)) =>
      if (win >= k) (mxI, win)
      else if (skill > skills(mxI)) (i + 1, 1)
      else (mxI, win + 1)
    }
    mxI
  }
}
