package leetCode.crackingCodeInterview

object Code_01_09 {
  def isFlipedString(s1: String, s2: String): Boolean = s1.length == s2.length && (s1 + s1).contains(s2)
}
