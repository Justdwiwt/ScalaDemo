package leetCode

object Solution_443 {
  def compress(chars: Array[Char]): Int = {
    var i = 0
    var j = 0
    while (j < chars.length) {
      if (j == chars.length - 1 || chars(j) != chars(j + 1)) {
        chars(i) = chars(j)
        i += 1
        j += 1
      } else {
        chars(i) = chars(j)
        i += 1
        val k = j
        while (j < chars.length && chars(j) == chars(k)) j += 1
        val s: Array[Char] = (j - k).toString.toCharArray
        s.foreach(c => {
          chars(i) = c
          i += 1
        })
      }
    }
    i
  }
}
