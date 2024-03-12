package leetCode._2100

object Solution_2038 {
  def winnerOfGame(colors: String): Boolean = {
    var cnt = 0
    colors.indices.dropRight(2).foreach(i => {
      if (colors.substring(i, i + 3).equals("AAA")) cnt += 1
      if (colors.substring(i, i + 3).equals("BBB")) cnt -= 1
    })
    cnt > 0
  }
}
