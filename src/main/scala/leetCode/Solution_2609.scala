package leetCode

object Solution_2609 {
  def findTheLongestBalancedSubstring(s: String): Int = {
    @scala.annotation.tailrec
    def one(s: List[Char], zeros: Int, ones: Int, res: Int): Int = s match {
      case h :: tails if h == '1' && zeros > 0 => one(tails, zeros - 1, ones + 1, res)
      case h :: tails if h == '1' => zero(tails, 0, 0, res.max(ones * 2))
      case h :: tails if h == '0' => zero(tails, 1, 0, res.max(ones * 2))
      case _ => res.max(ones * 2)
    }

    @scala.annotation.tailrec
    def zero(s: List[Char], zeros: Int, ones: Int, res: Int): Int = s match {
      case h :: tails if h == '0' => zero(tails, zeros + 1, 0, res)
      case h :: tails if h == '1' && zeros > 0 => one(tails, zeros - 1, 1, res)
      case h :: tails if h == '1' => zero(tails, 0, 0, res)
      case _ => res.max(ones * 2)
    }

    zero(s.toList, 0, 0, 0)
  }
}
