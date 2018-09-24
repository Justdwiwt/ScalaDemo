package algorithm

import java.security.MessageDigest

import javax.crypto.Cipher
import javax.crypto.spec.{IvParameterSpec, SecretKeySpec}
import sun.misc.BASE64Decoder

class Encryption {

  //noinspection ScalaUnusedSymbol
  def md5(): Unit = {
    val digest = MessageDigest.getInstance("MD5")
    val text = "需要加密的字符串"
    val md5hash1 = digest.digest(text.getBytes).map("%02x".format(_)).mkString
  }

  def desEncrypt(): String = try {
    //加密内容
    val data = "内容"
    //加密秘钥
    val key = "1234567812345678"
    //加密偏移量
    val iv = "1234567812345678"
    val encrypted1 = new BASE64Decoder().decodeBuffer(data)
    val cipher = Cipher.getInstance("AES/CBC/NoPadding")
    val keyspec = new SecretKeySpec(key.getBytes, "AES")
    val ivspec = new IvParameterSpec(iv.getBytes)
    cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec)
    val original = cipher.doFinal(encrypted1)
    //返回结果
    val originalString = new String(original)
    originalString
  } catch {
    case e: Exception =>
      e.printStackTrace()
      null
  }

}
