package leetCode._200

object Solution_139 {
  def wordBreak(s: String, wordDict: List[String]): Boolean = (1 to s.length)
    ./:(List(0))((acc, i) => if (acc.exists(x => wordDict.contains(s.substring(x, i)))) i :: acc else acc)
    .head == s.length
}
