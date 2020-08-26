package leetCode

object Solution_17 {
  def letterCombinations(digits: String): List[String] = {
    if (digits.isEmpty) return List.empty
    val diff = Array("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

    def f(s: String): IndexedSeq[String] = {
      if (s.isEmpty) IndexedSeq("")
      else diff(s.head - '2').flatMap(i => f(s.tail).map(j => i + j))
    }

    f(digits).toList
  }
}
