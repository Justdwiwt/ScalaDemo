package leetCode._1200

object Solution_1153 {
  def canConvert(str1: String, str2: String): Boolean = {
    if (str1 == str2) true
    else {
      val chars = str2.foldLeft(Array.fill(26)(0))((acc, c) => {
        val ind = c - 'a'
        if (acc(ind) == 0) acc.updated(ind, 1)
        else acc
      })
      val count = chars.count(_ != 0)
      if (count == 26) false
      else {
        val ends = Array.fill(26)(-1)
        val isValid = str1.indices.foldLeft(true)((isValid, i) => {
          if (!isValid) false
          else {
            val ind = str1(i) - 'a'
            if (ends(ind) != -1 && str2(ends(ind)) != str2(i)) false
            else {
              ends(ind) = i
              true
            }
          }
        })
        isValid
      }
    }
  }
}
