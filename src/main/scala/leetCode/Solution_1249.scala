package leetCode

object Solution_1249 {
  def minRemoveToMakeValid(s: String): String = {
    val res = new StringBuilder
    val st = new java.util.Stack[Int]
    val flag = new Array[Boolean](s.length)
    s.indices.foreach(i => {
      if (s(i) == '(') {
        st.push(i)
        flag(i) = true
      }
      if (s(i) == ')') {
        if (st.empty()) flag(i) = true
        else flag(st.pop()) = false
      }
    })
    s.indices.foreach(i => if (!flag(i)) res.append(s(i)))
    res.toString
  }
}
