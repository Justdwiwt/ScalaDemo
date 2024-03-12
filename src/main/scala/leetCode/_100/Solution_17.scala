package leetCode._100

object Solution_17 {
  private val diff = Array("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

  def getResult(idx: Int, path: String, digits: String): List[String] =
    if (idx == digits.length)
      List(path)
    else {
      val d = digits(idx).asDigit
      diff(d - 2).map(s => getResult(idx + 1, path + s, digits)).reduceRight(_ ++ _)
    }

  def letterCombinations(digits: String): List[String] =
    if (digits == "") List()
    else getResult(idx = 0, path = "", digits = digits)
}
