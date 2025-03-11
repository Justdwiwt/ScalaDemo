package leetCode._3500

// fixme: case 735/739 wrong answer
object Solution_3474 {
  def generateString(str1: String, str2: String): String = {
    val n = str1.length
    val m = str2.length
    val ans = Array.fill(n + m - 1)('0')
    val flag = Array.fill(n + m - 1)(false)

    str1
      .indices
      .withFilter(str1(_) == 'T')
      .foreach(i => str2.indices.foreach(j => {
        ans(i + j) = str2(j)
        flag(i + j) = true
      }))


    val invalid = str1
      .indices
      .filter(str1(_) == 'T')
      .exists(i => ans.slice(i, i + m).mkString != str2)

    if (invalid) return ""


    ans.indices.withFilter(ans(_) == '0').foreach(ans(_) = 'a')


    val failed = str1
      .indices
      .filter(i => str1(i) == 'F' && ans.slice(i, i + m).mkString == str2)
      .exists(i => ans
        .indices
        .slice(i, i + m)
        .reverse
        .find(j => !flag(j)) match {
        case Some(j) =>
          ans(j) = 'b'
          false
        case None => true
      })

    if (failed) "" else ans.mkString
  }
}
