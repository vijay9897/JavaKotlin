fun main() {
    val arr = intArrayOf(1,1)
    println(removeDuplicates(arr))
    println(arr.contentToString())
}

fun removeDuplicates(nums: IntArray): Int {
    var i = 0
    var prev = Int.MIN_VALUE
    var size = nums.size
    while(i < size) {
        if(nums[i] == prev) {
            var j = i+1
            var count = 1
            while(j < size && nums[j] == prev) {
                j++
                count++
            }
            for(k in i until size - count) {
                nums[k] = nums[j]
                j++
            }
            size -= count
        }
        prev = nums[i]
        i++
    }
    return size - 1
}