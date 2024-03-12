package leetCode.crackingCodeInterview

object Code_01_06 {
  @scala.annotation.tailrec
  def f(s: String, acc: String = ""): String = if (s == "") acc else f(s.dropWhile(_ == s.head), acc + s.head + s.takeWhile(_ == s.head).length)

  def compressString(S: String): String = if (f(S).length < S.length) f(S) else S
}
