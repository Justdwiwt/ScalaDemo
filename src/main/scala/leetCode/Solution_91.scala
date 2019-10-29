package leetCode

object Solution_91 {
  def numDecodings(s: String): Int = {
    val dp = Array.fill(s.length)(0)

    def func(i: Int) = if (i < 0) 1 else dp(i)

    s.indices.foreach(i => {
      if (s(i) != '0')
        dp(i) = func(i - 1)
      if (i - 1 >= 0 && s(i - 1) != '0' && s.substring(i - 1, i + 1) <= "26")
        dp(i) += func(i - 2)
    })
    dp.lastOption.getOrElse(0)
  }
}
