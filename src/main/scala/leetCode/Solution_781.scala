package leetCode

object Solution_781 {
  def numRabbits(answers: Array[Int]): Int = {
    var res = 0
    val cnt = Array.fill(1000)(0)
    answers.foreach(i => cnt(i) = (cnt(i) + 1) % (i + 1))
    (0 until 1000).foreach(i => if (cnt(i) != 0) res += i + 1 - cnt(i))
    res + answers.length
  }
}
