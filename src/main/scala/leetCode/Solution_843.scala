package leetCode

object Solution_843 {

  class Master {
    def guess(word: String): Int = ???
  }

  @scala.annotation.tailrec
  def findSecretWord(l: Array[String], m: Master): Unit = {
    val graph = Array.fill(l.length, l.length)(6)
    l.indices.foreach(i => (i + 1 until l.length).foreach(j => {
      graph(i)(j) = f(l(i), l(j))
      graph(j)(i) = f(l(i), l(j))
    }))

    def countGraph(i: Int): Array[Int] = {
      val res = Array.fill(7)(0)
      graph(i).foreach(x => res(x) += 1)
      res
    }

    val greedyGuess = l.indices.toList.minBy(i => countGraph(i).max)
    val cnt = m.guess(l(greedyGuess))
    if (cnt != 6) findSecretWord(l.filter(x => f(x, l(greedyGuess)) == cnt && x != l(greedyGuess)), m)
  }

  def f(s1: String, s2: String): Int = s1.zip(s2).count({ case (x, y) => x == y })
}
