package leetCode

object Solution_649 {
  def predictPartyVictory(senate: String): String = {
    val ch = senate.toCharArray
    val R = new java.util.LinkedList[Int]()
    val D = new java.util.LinkedList[Int]()
    ch.indices.foreach(i => if (ch(i) == 'R') R.offer(i) else D.offer(i))
    var pos = ch.length
    while (!R.isEmpty && !D.isEmpty) {
      val r = R.remove()
      val d = D.remove()
      if (r < d) {
        R.offer(pos)
        pos += 1
      } else {
        D.offer(pos)
        pos += 1
      }
    }
    if (R.isEmpty) "Dire" else "Radiant"
  }
}
