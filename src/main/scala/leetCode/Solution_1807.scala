package leetCode

object Solution_1807 {
  def evaluate(s: String, knowledge: List[List[String]]): String = {
    val m = knowledge.map(list => list.head -> list(1)).toMap
    val res = s.split('(').map(str => {
      val key = str.split(')')(0)
      var replacedKey = "?"
      if (m.contains(key)) replacedKey = m(key)
      str.replace(key + ')', replacedKey)
    })
    res.reduce((x, y) => x + y)
  }
}
