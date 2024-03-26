package leetCode._1500

object Solution_1456 {
  private val isVowel = Seq('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').toSet
  private val boolToInt = Map(false -> 0, true -> 1)

  @scala.annotation.tailrec
  def maxVowels(s: String, k: Int, first: Int = 0, max: Int = Int.MinValue)(implicit vowels: Int = s.take(k).count(isVowel)): Int =
    if (first + k >= s.length) max.max(vowels)
    else maxVowels(s, k, first + 1, max.max(vowels))(vowels - boolToInt(isVowel(s(first))) + boolToInt(isVowel(s(first + k))))
}
