fun main() {
    fun rollingWindowSum(input: List<Int>, windowSize: Int = 3): List<Int> {
        val result = List(input.size - windowSize + 1) { idx ->
            input.slice(idx until idx + windowSize).sum()
        }
        return result
    }

    fun noIncrease(intInput: List<Int>): Int {
        val diffList: List<Int> = List(intInput.size - 1) { idx ->
            if (intInput[idx + 1] - intInput[idx] <= 0) {
                0
            } else {
                1
            }
        }

        println(diffList)

        val incSum = diffList.sum()
        println("Number of increased measurements $incSum")
        return incSum
    }

    fun part1(input: List<String>): Int {
        //    The input list is of type List<String>. We know that our input contains a list of number,
        //    so we need to convert all the strings into Ints
        val intInput: List<Int> = input.map { it.toInt() }
        println(intInput)
        // Now that our list is in Int, we can do things like getting sum.
        // println(intInput.reduce { acc, it -> it + acc })
        // We are going to loop through the List and get the difference between the present value and the value above it
        return noIncrease(intInput)
    }

    fun part2(input: List<String>): Int {
        val intInput: List<Int> = input.map { it.toInt() }
        println(intInput)

        val rollingSumList = rollingWindowSum(intInput, 3)
        println("Rolling sum: $rollingSumList")


        return noIncrease(rollingSumList)
    }


    val testInput = readInput("day_01/test_input")
    check(part1(testInput) == 7)
    val realInput = readInput("day_01/input")
    check(part1(realInput) == 1665)

    check(part2(testInput) == 5)
    check(part2(realInput) == 1702)
}
