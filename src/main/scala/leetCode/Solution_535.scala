package leetCode

import scala.collection.mutable

object Solution_535 {

  class Codec {
    val shortToLong = mutable.Map.empty[String, String]

    // Encodes a URL to a shortened URL.
    def encode(longURL: String): String = {
      val shortURL = "http://tinyurl.com/" + longURL.hashCode
      shortToLong += shortURL -> longURL
      shortURL
    }

    // Decodes a shortened URL to its original URL.
    def decode(shortURL: String): String =
      shortToLong.getOrElse(shortURL, "")
  }

}
