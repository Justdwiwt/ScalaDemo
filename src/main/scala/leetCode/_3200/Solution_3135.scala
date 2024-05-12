package leetCode._3200

object Solution_3135 {
  def minOperations(initial: String, target: String): Int = {
    val initialLen = initial.length
    val targetLen = target.length

    def check(length: Int): Boolean =
      if (length == 0) true
      else {
        val initialSet = (length to initialLen).map(i => initial.substring(i - length, i)).toSet
        (length to targetLen).exists(i => initialSet.contains(target.substring(i - length, i)))
      }

    val (left, _) = Iterator.iterate((0, initialLen.min(targetLen))) {
      case (left, right) =>
        val mid = (left + right + 1) >> 1
        if (check(mid)) (mid, right)
        else (left, mid - 1)
    }.dropWhile { case (left, right) => left < right }.next()

    initialLen + targetLen - 2 * left
  }
}
