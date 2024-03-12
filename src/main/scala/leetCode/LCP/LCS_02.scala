package leetCode.LCP

object LCS_02 {
  def halfQuestions(questions: Array[Int]): Int = {
    val arr = Array.fill(1001)(0)
    var need = questions.length >> 1
    questions.foreach(x => arr(x) += 1)
    var cnt = 0
    val sorted = arr.sorted
    (1000 to 0 by -1).foreach(i => {
      if (need > 0) {
        need -= sorted(i)
        cnt += 1
      } else return cnt
    })
    questions.length >> 1
  }
}
