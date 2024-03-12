package leetCode._1200

object Solution_1105 {
  def minHeightShelves(books: Array[Array[Int]], shelf_width: Int): Int = {
    val dp = new Array[Int](books.length + 1)
    dp.indices.drop(1).foreach(i => {
      val width = books(i - 1)(0)
      var height = books(i - 1)(1)
      dp(i) = dp(i - 1) + height
      (1 until i)
        .reverse
        .withFilter(j => width + books.map(n => n.head).slice(j - 1, i - 1).sum <= shelf_width)
        .foreach(j => {
          height = height.max(books(j - 1)(1))
          dp(i) = dp(i).min(dp(j - 1) + height)
        })
    })
    dp(books.length)
  }
}
