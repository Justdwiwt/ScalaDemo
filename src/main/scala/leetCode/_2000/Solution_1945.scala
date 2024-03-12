package leetCode._2000

object Solution_1945 {
  def getLucky(s: String, k: Int): Int = {
    var res = s.map(_ - 'a' + 1).mkString.toArray.map(_ - '0')
    (1 until k).foreach(_ => res = res.sum.toString.map(_ - '0').toArray)
    res.sum
  }
}
