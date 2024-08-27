fun main() {
    println(myAtoi("-+12"))
}

fun myAtoi(s: String): Int {
    val sb = StringBuilder()
    var counter = 0
    var digitFound = false
    while (counter < s.length) {
        val ch = s[counter]
        if (ch.isDigit()) {
            digitFound = true
            sb.append(ch)
        } else if((ch == '+' || ch == '-') && sb.isEmpty()) {
            sb.append(ch)
        } else if(ch == ' '){
            if (digitFound)
                break
        } else {
            break
        }
        counter++
    }
    if (!digitFound)
        return 0
    return try {
        sb.toString().toInt()
    } catch (e: NumberFormatException) {
        if (sb[0] == '-') {
            Int.MIN_VALUE
        } else {
            Int.MAX_VALUE
        }
    }
}