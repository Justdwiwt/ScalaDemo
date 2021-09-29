package leetCode

object Offer_005 {
  def maxProduct(words: Array[String]): Int = {
    val nums = words.map(str => if (str == "") 0 else str.map(c => 1 << (c - 'a')).reduce(_ | _))
    var maxLen = 0
    nums.indices.foreach(i => (i + 1 until nums.length).foreach(j =>
      if ((nums(i) & nums(j)) == 0 && words(i).length * words(j).length > maxLen)
        maxLen = words(i).length * words(j).length))
    maxLen
  }
}
