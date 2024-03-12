package leetCode._2700

object Solution_2660 {
  def isWinner(player1: Array[Int], player2: Array[Int]): Int = {
    var p1 = 0
    var p2 = 0
    player1.indices.foreach(i => {
      p1 += player1(i)
      if ((i > 0 && player1(i - 1) == 10) || (i > 1 && player1(i - 2) == 10)) p1 += player1(i)
      p2 += player2(i)
      if ((i > 0 && player2(i - 1) == 10) || (i > 1 && player2(i - 2) == 10)) p2 += player2(i)
    })
    if (p1 > p2) 1 else if (p2 > p1) 2 else 0
  }
}
