package leetCode

object Solution_868 {
  def binaryGap(N: Int): Int = {
    var res = 0
    var flag = 1
    var p = -1
    var current = 0
    var index = 0
    while (flag < N) {
      if ((flag & N) != 0)
        if (p == -1) p = index
        else {
          current = index
          res = math.max(res, current - p)
          p = current
        }
      index += 1
      flag <<= 1
    }
    res
  }
}
