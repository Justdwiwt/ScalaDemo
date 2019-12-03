package leetCode

object Solution_791 {
  def customSortString(S: String, T: String): String = {
    var res = ""
    val cnt = Array.fill(26)(0)
    T.foreach(i => cnt(i - 'a') += 1)
    S.foreach(i => {
      while (cnt(i - 'a') > 0) {
        cnt(i - 'a') -= 1
        res :+= i
      }
    })
    T.foreach(i => {
      while (cnt(i - 'a') > 0) {
        cnt(i - 'a') -= 1
        res :+= i
      }
    })
    res
  }
}
