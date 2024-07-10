package leetCode._2600

object Solution_2502 {

}

class Allocator(n: Int) {
  private val u = Array.fill(n)(0)
  private val c = Array.fill(n)(0)

  c(n - 1) = 1
  (0 until n - 1).reverse.foreach(i => c(i) = c(i + 1) + 1)

  def allocate(size: Int, mID: Int): Int = {
    var res = -1
    var i = 0
    while (i < n && res == -1) {
      if (c(i) >= size) {
        (i until i + size).foreach(j => {
          u(j) = mID
          c(j) = 0
        })
        res = i
      }
      i += 1
    }
    res
  }

  def free(mID: Int): Int = {
    var f = 0
    (0 until n).foreach(i => if (u(i) == mID) {
      u(i) = 0
      f += 1
    })

    c(n - 1) = if (u(n - 1) == 0) 1 else 0
    (0 until n - 1).reverse.foreach(i => c(i) = if (u(i) == 0) c(i + 1) + 1 else 0)
    f
  }
}
