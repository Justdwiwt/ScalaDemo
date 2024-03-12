package leetCode._2400

import java.util

object Solution_2355 {
  def maximumBooks(books: Array[Int]): Long = {
    val n = books.length
    var res = 0L
    val dp = Array.fill(n)(0L)
    dp(0) = books.head
    val st = new util.LinkedList[Int]()
    books.indices.foreach(i => {
      while (!st.isEmpty && books(st.peek()) - st.peek() > books(i) - i) st.pop()
      val j = if (st.isEmpty) -1 else st.peek()
      st.push(i)
      val cnt = books(i).min(i - j)
      val sum = (((books(i) - cnt + 1) + books(i)) * cnt / 2).toLong
      dp(i) = sum + (if (j == -1) 0 else dp(j))
      res = res.max(dp(i))
    })
    res
  }
}
