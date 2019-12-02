package leetCode

import scala.util.control.Breaks._

object Solution_1025 {
  def divisorGame(N: Int): Boolean = N % 2 == 0

  def divisorGame2(N: Int): Boolean = {
    val dp = Array.fill(N + 1)(0)
    (1 to N).foreach(k =>
      breakable {
        (1 until k).foreach(m => {
          if (k % (k - m) == 0 && dp(m) == 0) {
            dp(k) = 1
            break
          }
        })
      }
    )
    dp(N) == 1
  }
}
