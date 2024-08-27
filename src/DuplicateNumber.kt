fun main() {
    val nums = intArrayOf(3,1,3,4,2)
    val length = nums.size
    var i = 0
    while (i < length) {
        if (nums[i] != i +1) {
            val correct = nums[i] - 1
            if (nums[i] != nums[correct]) {
                val temp = nums[i]
                nums[i] = nums[correct]
                nums[correct] = temp
            } else {
                return println(nums[i])
            }
        } else {
            i++
        }
    }
}