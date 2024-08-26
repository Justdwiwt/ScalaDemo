package leetCode._3300

object Solution_3260 {
  def largestPalindrome(n: Int, k: Int): String = {
    def f(out: String, in: String = ""): String = {
      val init = (out + ("9" * (n - 2 * out.length)) + out) take n
      init.patch((n - 1) / 2, in, in.length)
    }

    k match {
      case 1 | 3 | 9 => f("9")
      case 2 => f("8")
      case 4 => f("88")
      case 5 => f("5")
      case 6 =>
        val patches = Array("77", "8")
        if (n <= 2) f("6") else f("8", patches(n % 2))
      case 7 =>
        val patches = Array("", "7", "77", "5", "77", "7", "", "4", "44", "6", "44", "4")
        f("9", patches(n % 12))
      case 8 => f("888")
    }
  }
}
