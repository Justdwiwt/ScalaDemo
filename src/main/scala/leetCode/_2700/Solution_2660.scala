package leetCode._2700

object Solution_2660 {
  def isWinner(player1: Array[Int], player2: Array[Int]): Int = {
    val (score1, score2) = (f(player1), f(player2))
    if (score1 > score2) 1 else if (score1 < score2) 2 else 0
  }

  private def f(scores: Array[Int]): Int = scores.toSeq match {
    case Seq(score) => score
    case Seq(score1, score2) => if (score1 == 10) score1 + 2 * score2 else score1 + score2
    case score1 +: score2 +: _ =>
      val initScore = if (score1 == 10) score1 + 2 * score2 else score1 + score2
      scores.sliding(3).foldLeft(initScore) { case (score, Array(prev2, prev1, curr)) =>
        if (prev2 == 10 || prev1 == 10) score + curr * 2 else score + curr
      }
  }
}
