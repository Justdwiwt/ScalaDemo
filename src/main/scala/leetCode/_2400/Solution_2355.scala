package leetCode._2400

object Solution_2355 {
  def maximumBooks(books: Array[Int]): Long = {
    val n = books.length
    var res = 0L
    val dp = new Array[Long](n)
    dp(0) = books.head
    var stack = List.empty[Int]

    books.indices.foreach(i => {
      while (stack.nonEmpty && books(stack.head) - stack.head > books(i) - i)
        stack = stack.tail
      val j = if (stack.isEmpty) -1 else stack.head
      stack = i :: stack
      val count = books(i).min(i - j)
      val sum = ((books(i) - count + 1L) + books(i)) * count / 2
      dp(i) = sum + (if (j == -1) 0 else dp(j))
      res = res.max(dp(i))
    })
    res
  }
}
