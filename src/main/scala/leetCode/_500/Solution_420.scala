package leetCode._500

object Solution_420 {
  def strongPasswordChecker(password: String): Int = {
    var p = Password(password.toVector)
    var cnt = 0
    while (!isStrongPassword(p)) {
      val firstRepetitionOpt = p.longRepeating.headOption.map(_._1 + 2)
      if (p.length < 6) {
        val insertionPoint = firstRepetitionOpt.getOrElse(0)
        p = p.insertAt(insertionPoint, p.bestToInsertChar(insertionPoint))
      } else if (p.length > 20)
        p = p.deleteAt(firstRepetitionOpt.getOrElse(p.bestToChangeIndex))
      else {
        val updatePoint = firstRepetitionOpt.getOrElse(p.bestToChangeIndex)
        p = p.updateAt(updatePoint, p.bestToInsertChar(updatePoint))
      }
      cnt += 1
    }
    cnt
  }

  private def isStrongPassword(password: Password): Boolean = {
    if (password.length < 6) return false
    if (password.length > 20) return false
    if (!password.hasLower || !password.hasUpper || !password.hasDigit) return false
    if (password.longRepeating.nonEmpty) return false
    true
  }

  case class Password(password: Vector[Char]) {
    val length: Int = password.length
    private val lowerChars: Int = password.count(c => c >= 'a' && c <= 'z')
    private val upperChars: Int = password.count(c => c >= 'A' && c <= 'Z')
    private val digitChars: Int = password.count(c => c >= '0' && c <= '9')
    val hasLower: Boolean = lowerChars > 0
    val hasUpper: Boolean = upperChars > 0
    val hasDigit: Boolean = digitChars > 0
    val longRepeating: List[(Int, Int)] = password
      .:+('_')
      .zipWithIndex
      .foldLeft(('_', 0, Option.empty[Int], List.empty[(Int, Int)])) {
        case ((lastChar, _, None, res), (char, index)) if char == lastChar => (char, 2, Some(index - 1), res)
        case ((lastChar, repLen, Some(repStart), res), (char, _)) if char == lastChar => (char, repLen + 1, Some(repStart), res)
        case ((_, repLen, Some(repStart), res), (char, _)) if repLen >= 3 => (char, 0, None, (repStart, repLen) :: res)
        case ((_, _, _, res), (char, _)) => (char, 0, None, res)
      }
      ._4
      .sortWith { case ((_, len1), (_, len2)) => if (len1 % 3 < len2 % 3) true else false }

    def bestToInsertChar(index: Int): Char = {
      val replacement = if (!hasLower) 'z'
      else if (!hasUpper) 'Z'
      else if (!hasDigit) '9'
      else 'Z'
      if (password(index) == replacement) (replacement - 1).toChar
      else replacement
    }

    def bestToChangeIndex: Int = {
      if (lowerChars > 1) return password.indexWhere(c => c >= 'a' && c <= 'z')
      if (upperChars > 1) return password.indexWhere(c => c >= 'A' && c <= 'Z')
      if (digitChars > 1) return password.indexWhere(c => c >= '0' && c <= '9')
      0
    }

    def insertAt(pos: Int, char: Char): Password =
      copy(password.slice(0, pos).:+(char) ++ password.slice(pos, password.length))

    def updateAt(pos: Int, char: Char): Password =
      copy(password.updated(pos, char))

    def deleteAt(pos: Int): Password =
      copy(password.slice(0, pos) ++ password.slice(pos + 1, password.length))

    override def toString: String = String.valueOf(password) +
      ",length=" + length +
      ",hasLower=" + hasLower +
      ",hasUpper=" + hasUpper +
      ",hasDigit=" + hasDigit +
      ",longRepeating=" + longRepeating
  }
}
