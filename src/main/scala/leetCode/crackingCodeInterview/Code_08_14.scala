package leetCode.crackingCodeInterview

object Code_08_14 {
  private val map = collection.mutable.HashMap.empty[List[Any], Int]

  def countEval(s: String, result: Int): Int = {
    if (s.length == 1) return if (result == s.toInt) 1 else 0
    var res = 0
    s.indices.foreach(i => if (s(i) == '0' || s(i) == '1') ()
    else {
      val left: String = s.substring(0, i)
      val right: String = s.substring(i + 1)
      if (!map.contains(List(left, 0))) map.put(List(left, 0), countEval(left, 0))
      if (!map.contains(List(left, 1))) map.put(List(left, 1), countEval(left, 1))
      if (!map.contains(List(right, 0))) map.put(List(right, 0), countEval(right, 0))
      if (!map.contains(List(right, 1))) map.put(List(right, 1), countEval(right, 1))

      val left0 = map(List(left, 0))
      val left1 = map(List(left, 1))
      val right0 = map(List(right, 0))
      val right1 = map(List(right, 1))
      s(i) match {
        case '&' => res += (if (result == 0) left0 * right0 + left0 * right1 + left1 * right0 else left1 * right1)
        case '|' => res += (if (result == 0) left0 * right0 else left1 * right0 + left0 * right1 + left1 * right1)
        case _ => res += (if (result == 0) left0 * right0 + left1 * right1 else left0 * right1 + left1 * right0)
      }
    })
    res
  }
}
