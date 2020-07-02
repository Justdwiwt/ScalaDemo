package leetCode

object Solution_838 {
  def pushDominoes(dominoes: String): String = {
    val s = dominoes.toCharArray
    val N = s.length
    val arr = Array.fill(s.length)(0)
    var t = 0
    s.indices.foreach(i => {
      if (s(i) == 'R') t = N
      else if (s(i) == 'L') t = 0
      else t = (t - 1).max(0)
      arr(i) += t
    })
    t = 0
    (s.length - 1 to 0 by (-1)).foreach(i => {
      if (s(i) == 'L') t = N
      else if (s(i) == 'R') t = 0
      else t = (t - 1).max(0)
      arr(i) -= t
    })
    var res = ""
    arr.foreach(i => res :+= (if (i > 0) 'R' else if (i < '0') 'L' else '.'))
    res
  }
}
