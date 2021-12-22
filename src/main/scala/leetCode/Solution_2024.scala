package leetCode

object Solution_2024 {
  def maxConsecutiveAnswers(answerKey: String, k: Int): Int = {
    var cntT = 0
    var cntF = 0
    var p = 0
    var res = 0
    answerKey.indices.foreach(i => {
      if (answerKey(i) == 'T') cntT += 1
      else cntF += 1
      while (cntF.min(cntT) > k) {
        if (answerKey(p) == 'T') cntT -= 1
        else cntF -= 1
        p += 1
      }
      res = res.max(1 + i - p)
    })
    res
  }
}
