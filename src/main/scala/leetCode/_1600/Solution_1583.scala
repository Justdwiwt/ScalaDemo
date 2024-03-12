package leetCode._1600

object Solution_1583 {
  private var preferences: Array[Array[Int]] = _
  private var pairs: Array[Array[Int]] = _

  def unhappyFriends(n: Int, preferences: Array[Array[Int]], pairs: Array[Array[Int]]): Int = {
    this.preferences = preferences
    this.pairs = pairs
    pairs.map(pair => pair.count(x => f(pair.indexOf(x), pair))).sum
  }

  private def f(i: Int, pair: Array[Int]): Boolean = {
    val x = pair(i)
    val y = pair((i + 1) % 2)
    val pref = preferences(x)
    val us = pref.slice(0, pref.indexWhere(_ == y))
    us.exists(u => {
      val v = pairs.find(pair => pair(0) == u || pair(1) == u).get.find(_ != u).get
      val pref = preferences(u)
      pref.indexOf(x) < pref.indexOf(v)
    })
  }
}
