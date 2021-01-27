package leetCode

object Solution_1736 {
  def maximumTime(time: String): String = {
    val seq = time.split(":")
    val hh = seq.head
    val mm = seq(1)
    var res = ""
    hh match {
      case "??" => res += "23:"
      case ch if ch(0) == '?' && ch(1) < '4' => res += "2" + ch(1) + ":"
      case ch if ch(0) == '?' && ch(1) >= '4' => res += "1" + ch(1) + ":"
      case ch if ch(1) == '?' && ch(0) < '2' => res += ch(0) + "9" + ":"
      case ch if ch(1) == '?' && ch(0) == '2' => res += hh(0) + "3" + ":"
      case _ => res += hh + ":"
    }
    mm match {
      case "??" => res += "59"
      case ch if ch(0) == '?' => res += "5" + ch(1)
      case ch if ch(1) == '?' => res += ch(0) + "9"
      case _ => res += mm
    }
    res
  }
}
