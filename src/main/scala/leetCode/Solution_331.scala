package leetCode

object Solution_331 {
  def isValidSerialization(preorder: String): Boolean = {
    var res = 1
    preorder.split(",").foreach(i => {
      res -= 1
      if (res < 0) return false
      if (!i.equals("#")) res += 2
    })
    res == 0
  }
}
