package leetCode

object Solution_1309 {
  def freqAlphabets(s: String): String = {
    var res = ""
    var idx = 0
    while (idx < s.length) {
      if (idx <= s.length - 3 && s.charAt(idx + 2).equals('#')) {
        res = res + (s.slice(idx, idx + 2).toInt + 96).toChar
        idx = idx + 3
      }
      else {
        res = res + (s.charAt(idx) + 'a' - '1').toChar
        idx = idx + 1
      }
    }
    res
  }
}
