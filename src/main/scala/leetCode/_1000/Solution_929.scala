package leetCode._1000

object Solution_929 {
  def numUniqueEmails(emails: Array[String]): Int = emails
    .map(_.split("@"))
    .map(mail => mail.head.split("[+]").head.replace(".", "") + "@" + mail.last)
    .distinct
    .length
}
