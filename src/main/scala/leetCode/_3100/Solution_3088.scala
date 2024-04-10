package leetCode._3100

object Solution_3088 {
  def makeAntiPalindrome(s: String): String = {
    val count = Array.ofDim[Int](26)
    val cs = s.toCharArray
    val n = cs.length

    cs.foreach(c => count(c - 'a') += 1)

    val maxCount = count.max
    if (maxCount > n / 2) {
      return "-1"
    }

    var index = 0
    (0 until 26).foreach(i => {
      val c = count(i)
      var temp = c
      while (temp > 0) {
        cs(index) = (i + 'a').toChar
        index += 1
        temp -= 1
      }
    })

    if (cs(n / 2) == cs(n / 2 - 1)) {
      val midIndex = cs(n / 2) - 'a'
      var midSum = 0
      (0 to midIndex).foreach(midSum += count(_))
      val rightCount = midSum - n / 2
      val leftCount = count(midIndex) - rightCount
      val start = n / 2
      (0 until leftCount).foreach(k => cs(start + k) = cs(start + rightCount + k))
      (0 until rightCount).foreach(k => cs(start + leftCount + k) = cs(start - 1))
    }
    new String(cs)
  }
}
