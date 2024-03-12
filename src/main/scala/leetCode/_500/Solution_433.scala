package leetCode._500

object Solution_433 {
  def minMutation(start: String, end: String, bank: Array[String]): Int =
    f(Set(toInt(start)), toInt(end), bank.map(toInt).toSet, 0)

  @scala.annotation.tailrec
  def f(q: Set[Int], end: Int, dict: Set[Int], turn: Int): Int =
    if (q.isEmpty) -1
    else if (q.contains(end)) turn
    else {
      val sep = dict.partition(g => q.exists(related(g)))
      f(sep._1, end, sep._2, turn + 1)
    }

  def toInt(s: String): Int = s./:(0)((d, c) => toDigits(c) | (d << 2))

  def related(s1: Int)(s2: Int): Boolean = oneLetter(s1 ^ s2)

  def oneLetter(n: Int): Boolean = oneBit(n) || oneBit(n - (0xAAAAAAAA & (n & (n << 1))))

  def oneBit(n: Int): Boolean = (n > 0) && (n & (n - 1)) == 0

  def toDigits(ch: Char): Int = ch match {
    case 'A' => 0
    case 'C' => 1
    case 'G' => 2
    case 'T' => 3
  }
}
