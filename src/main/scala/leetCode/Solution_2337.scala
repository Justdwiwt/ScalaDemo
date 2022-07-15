package leetCode

object Solution_2337 {
  def canChange(start: String, target: String): Boolean = nonBlanks(start)
    .corresponds(nonBlanks(target))(_ == _) && indicesOf(start, 'L')
    .corresponds(indicesOf(target, 'L'))(_ >= _) && indicesOf(start, 'R')
    .corresponds(indicesOf(target, 'R'))(_ <= _)

  private def nonBlanks(s: String): Iterator[Char] =
    s.iterator.filter(_ != '_')

  private def indicesOf(s: String, c: Char): Iterator[Int] =
    s.iterator.zipWithIndex.collect { case (c1, i) if c1 == c => i }
}
