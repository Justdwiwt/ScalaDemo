package leetCode

object Solution_929 {
  def numUniqueEmails(emails: Array[String]): Int = emails.map(func).toSet.size

  def func(s: String): String = removeDot(removePlus(s.split("@")(0))) + "@" + s.split("@")(1)

  def removePlus(in: String): String = if (in.indexOf("+") < 0) in else in.substring(0, in.indexOf("+"))

  def removeDot(in: String): String = in.replace(".", "")
}
