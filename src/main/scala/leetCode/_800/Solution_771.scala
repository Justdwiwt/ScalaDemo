package leetCode._800

object Solution_771 {
  def numJewelsInStones(J: String, S: String): Int = {
    S.count(i => J.contains(i))
  }
}
