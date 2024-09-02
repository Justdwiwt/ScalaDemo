package leetCode._2100

object Solution_2024 {
  def maxConsecutiveAnswers(answerKey: String, k: Int): Int = {
    @scala.annotation.tailrec
    def f(l: Int, r: Int, maxLen: Int)(TF: (Int, Int)): Int =
      if ((TF._1 min TF._2) <= k) {
        if (r == answerKey.length) maxLen.max(r - l)
        else f(l, r + 1, maxLen.max(r - l))(answerKey(r) match {
          case 'T' => (TF._1 + 1, TF._2)
          case 'F' => (TF._1, TF._2 + 1)
        })
      } else f(l + 1, r, maxLen)(answerKey(l) match {
        case 'T' => (TF._1 - 1, TF._2)
        case 'F' => (TF._1, TF._2 - 1)
      })

    f(0, 0, 0)(0, 0)
  }
}
