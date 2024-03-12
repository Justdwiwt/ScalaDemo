package leetCode.crackingCodeInterview

object Code_17_13 {
  def respace(dictionary: Array[String], sentence: String): Int = {
    val dp = Array.fill(sentence.length + 1)(0)
    dp(0) = 0
    (1 to sentence.length).foreach(i => {
      dp(i) = dp(i - 1) + 1
      dictionary.foreach(word => {
        if (word.length <= i && word.equals(sentence.substring(i - word.length, i)))
          dp(i) = dp(i).min(dp(i - word.length))
      })
    })
    dp(sentence.length)
  }
}
