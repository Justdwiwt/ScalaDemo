package leetCode

object Solution_1616 {
  def checkPalindromeFormation(a: String, b: String): Boolean = {
    val chA = a.toCharArray
    val chB = b.toCharArray
    var flagA = true
    var flagB = true

    def check(arr: Array[Char], l: Int, r: Int): Boolean = {
      (0 until (r - l + 1) / 2).foreach(i => if (arr(l + i) != arr(r - i)) return false)
      true
    }

    (0 until a.length / 2).foreach(i => {
      if (flagA) if (chA(i) != chB(a.length - 1 - i)) {
        if (!flagB) if (check(chB, i, a.length - 1 - i) || check(chA, i, a.length - 1 - i)) return true
        flagA = false
      }
      if (flagB) if (chB(i) != chA(a.length - 1 - i)) {
        if (!flagA) if (check(chB, i, a.length - 1 - i) || check(chA, i, a.length - 1 - i)) return true
        flagB = false
      }
      if (!flagA && !flagB) return false
    })
    true
  }
}
