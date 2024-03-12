package leetCode._500

object Solution_422 {
  def validWordSquare(words: List[String]): Boolean = {
    if (words.isEmpty) return true
    words.indices.foreach(i => words(i).indices.foreach(j => {
      if (words.length <= j) return false
      if (words(j).length <= i) return false
      if (words(j)(i) != words(i)(j)) return false
    }))
    true
  }
}
