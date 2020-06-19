package leetCode

import scala.util.control.Breaks._

object Solution_1105 {
  def minHeightShelves(books: Array[Array[Int]], shelf_width: Int): Int = {
    val cache = Array.fill(books.length)(-1)

    def dfs(books: Array[Array[Int]], idx: Int, width: Int, cache: Array[Int]): Int = {
      if (idx >= books.length) return 0
      if (cache(idx) != -1) return cache(idx)
      var curWidth = 0
      var mxHeight = 0
      var res = Int.MaxValue
      breakable {
        (idx until books.length).foreach(i => {
          curWidth += books(i)(0)
          mxHeight = mxHeight.max(books(i)(1))
          if (curWidth > width) break()
          res = res.min(mxHeight + dfs(books, i + 1, width, cache))
        })
      }
      cache(idx) = res
      res
    }

    dfs(books, 0, shelf_width, cache)
  }
}
