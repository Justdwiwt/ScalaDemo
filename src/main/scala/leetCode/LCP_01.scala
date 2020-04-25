package leetCode

object LCP_01 {
  def game(guess: Array[Int], answer: Array[Int]): Int = {
    var res = 0
    guess.indices.foreach(i => if (guess(i) == answer(i)) res += 1)
    res
  }
}
