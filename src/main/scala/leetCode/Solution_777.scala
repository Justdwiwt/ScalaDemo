package leetCode

object Solution_777 {
  def canTransform(start: String, end: String): Boolean = {
    val n = start.length
    var i = 0
    var j = 0
    while (i < n && j < n) {
      while (i < n && start(i) == 'X') i += 1
      while (j < n && end(j) == 'X') j += 1
      if (i < n && j < n) {
        if (start(i) != end(j) || (start(i) == 'L' && i < j) || (start(i) == 'R' && i > j)) return false
        else {
          i += 1
          j += 1
        }
      }
    }
    while (i < n && start(i) == 'X') i += 1
    while (j < n && end(j) == 'X') j += 1
    if (i != j) return false
    true
  }
}
