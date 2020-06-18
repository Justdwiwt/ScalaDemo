package leetCode

object Solution_1003 {
  def isValid(S: String): Boolean = {
    val sb = new StringBuilder(S)
    (0 until S.length / 3).foreach(_ => {
      val idx = sb.indexOf("abc")
      if (idx == -1) return false
      sb.delete(idx, idx + 3)
    })
    sb.toString().equals("")
  }
}
