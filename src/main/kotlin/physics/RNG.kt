package physics

/*
Example source:
https://courses.physics.ucsd.edu/2018/Spring/physics142/Labs/Lab7/PathIntegralGPU.pdf

Random number generator using Xorshift

Example:
seed: Int

51       ->      51             ->      102
                 85
00110011 ->     00110011        ->      011001102
                01010101

General idea:
- Given an 8 bit integer:
        - For each bit
*/

class RngModel (
        val seed: Long,
        val a: Long,
        val b: Long
        )