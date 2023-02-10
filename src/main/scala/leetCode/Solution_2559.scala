package leetCode

object Solution_2559 {
  private val diff = Set('a', 'e', 'i', 'o', 'u')

  def vowelStrings(words: Array[String], queries: Array[Array[Int]]): Array[Int] = {
    var c = 0
    val cnt = words.map(w => {
      if (diff.contains(w.head) && diff.contains(w.last)) c += 1
      c
    })
    queries.map(q => if (q.head == 0) cnt(q(1)) else cnt(q(1)) - cnt(q.head - 1))
  }
}
