package leetCode._800

object Solution_761 {
  def makeLargestSpecial(S: String): String = {
    var cnt, i = 0
    val res = collection.mutable.ListBuffer[String]()
    S.indices.foreach(j => {
      if (S(j) == '1') cnt += 1
      else cnt -= 1
      if (cnt == 0) {
        res += "1" + makeLargestSpecial(S.substring(i + 1, j)) + "0"
        i = j + 1
      }
    })
    res.sorted.reverse.mkString
  }
}
