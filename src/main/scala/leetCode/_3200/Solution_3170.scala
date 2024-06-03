package leetCode._3200

object Solution_3170 {
  def clearStars(s: String): String = {
    val arr = Array.fill(s.length)(false)
    val st = Array.fill(26)(collection.mutable.Stack[Int]())

    s.zipWithIndex.foreach { case (c, i) =>
      if (c != '*') st(c - 'a').push(i)
      else st.find(_.nonEmpty).foreach(p => arr(p.pop()) = true)
    }

    s.zip(arr).collect { case (c, d) if !d && c != '*' => c }.mkString
  }
}
