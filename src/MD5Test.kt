import java.math.BigInteger
import java.security.MessageDigest

fun main() {
    println(md5Hash("demo@123"))
}

fun md5Hash(str: String): String {
    val md = MessageDigest.getInstance("MD5")
    val bigInt = BigInteger(1, md.digest(str.toByteArray(Charsets.UTF_8)))
    return String.format("%032x", bigInt)
}