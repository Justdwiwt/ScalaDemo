package leetCode

object Solution_2266 {
  def countTexts(pressedKeys: String): Int = {
    var q: List[BigInt] = List(1)
    var idx = 1
    var curLen = 1
    while (idx < pressedKeys.length) {
      val upperBound = if (pressedKeys(idx) == '7' || pressedKeys(idx) == '9') 4 else 3
      if (pressedKeys(idx) == pressedKeys(idx - 1))
        curLen = (curLen + 1).min(upperBound)
      else
        curLen = 1
      q = q.sum +: q
      while (q.length > curLen) q = q.dropRight(1)
      idx += 1
    }
    (q.sum % (math.pow(10, 9) + 7).toInt).toInt
  }
}
