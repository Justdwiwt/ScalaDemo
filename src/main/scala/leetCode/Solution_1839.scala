package leetCode

object Solution_1839 {
  def longestBeautifulSubstring(word: String): Int = {
    var left = 0
    var res = 0
    while (left < word.length)
      if (word(left) == 'a') {
        var right = left
        var last = 'a'
        var cnt = 1
        while (right < word.length && word(right) >= last) {
          if (word(right) > last) cnt += 1
          last = word(right)
          right += 1
        }
        if (last == 'u' && cnt == 5) res = res.max(right - left)
        left = right
      } else left += 1
    res
  }
}
