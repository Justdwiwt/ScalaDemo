package leetCode.crackingCodeInterview

object Code_16_20 {
  private val diff = Array(2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9)

  def getValidT9Words(num: String, words: Array[String]): List[String] = {
    val nums = getNum(num)
    var res = List.empty[String]
    words.indices.foreach(i => if (getNum4word(words(i)) == nums) res ::= words(i))
    res.reverse
  }

  private def getNum(word: String): Int = {
    var num = 0
    word.indices.foreach(i => num = num * 10 + word(i) - '0')
    num
  }

  private def getNum4word(word: String): Int = {
    var num = 0
    word.indices.foreach(i => num = num * 10 + diff(word(i) - 'a'))
    num
  }
}
