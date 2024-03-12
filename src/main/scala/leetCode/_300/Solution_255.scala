package leetCode._300

object Solution_255 {
  def verifyPreorder(preorder: Array[Int]): Boolean = {
    var top = -1
    var mn = Int.MinValue
    val st = Array.fill(preorder.length)(0)
    preorder.foreach(v => {
      if (v < mn) return false
      while (top > -1 && v > st(top)) {
        mn = st(top)
        top -= 1
      }
      top += 1
      st(top) = v
    })
    true
  }
}
