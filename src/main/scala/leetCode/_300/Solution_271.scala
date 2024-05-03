package leetCode._300

object Solution_271 {

  class Codec {
    // Encodes a list of strings to a single string.
    def encode(strs: List[String]): String = {
      if (strs.isEmpty) return "\u0102" // Unicode character 258

      val delimiter = "\u0101" // Unicode character 257
      strs.mkString(delimiter)
    }

    // Decodes a single string to a list of strings.
    def decode(s: String): List[String] = {
      val delimiter = "\u0102" // Unicode character 258
      if (s == delimiter) return Nil

      val delimiter2 = "\u0101" // Unicode character 257
      s.split(delimiter2, -1).toList
    }
  }

}
