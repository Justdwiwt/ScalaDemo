package leetCode.crackingCodeInterview

object Code_17_18 {
  def shortestSeq(big: Array[Int], small: Array[Int]): Array[Int] = {
    var res = Array.empty[Int]
    val smallLen = small.length
    val bigLen = big.length
    var left = 0
    var right = 0
    var minLen = bigLen
    val map = scala.collection.mutable.Map.empty[Int, Int]

    small.foreach(map.put(_, 1))

    var currentSmallLen = smallLen

    while (right < bigLen) {
      if (map.contains(big(right))) {
        if (map(big(right)) > 0) currentSmallLen -= 1

        map.put(big(right), map(big(right)) - 1)
      }

      while (currentSmallLen == 0) {
        if (right - left < minLen) {
          minLen = right - left
          res = Array(left, right)
        }
        if (map.contains(big(left))) {

          map.put(big(left), map(big(left)) + 1)

          if (map(big(left)) > 0) currentSmallLen += 1
        }
        left += 1
      }
      right += 1
    }

    res
  }
}
