## The pdf explained Algorithm R, X and Y.
# Problem
The problem is to select a random sample of size n from a set of size N with following limitation:
* N is not given and we can’t generate any knowledge of N. Hence, it needs to be finished in one pass since N is not known.
* Every element of N has the same probabilities to be selected (this is what “random sample” requires)

If N is known, it’s relatively easy to do random sampling - we will just need to generate n random numbers from[1, N]. If N is not known, how do we make sure each element will be selected with the same probability?

This problem occurs frequently in the real world. For example, to select 1000 words from a super thick dictionary whose total number of words is not known. To select 300 samples from an ongoing data stream and we don’t know when the stream will end. Therefore, optimizing this problem will help with solving these problems.
# Reservoir Algorithm
Reservoir algorithms are the solution to the above random sampling problem which needs to be finished in one pass. In other words, the time complexity is O(N). A “reservoir” is created to temporarily store candidates of samples that we should only keep track of. The size of the reservoir can be larger than n or equals to n.

Algorithm R, X, and Y all major players in reservoir algorithms. 
# Summary
A big jump is from Algorithm R to Algorithm Y with:
* The idea of skipping numbers and,
* The usage of Newton’s interpolation method to find out the proper number of elements to skip during each iteration.

To sum up, a series of reservoir algorithms such as R, X, and Y were developed and were optimized. All of them need to create a reservoir to temporarily store correct samples in case that it’s needed at any time (i.e., the date stream ends at any time and the reservoir will be able to provide the correct result correspondingly).

R decides whether to place the number into the reservoir on EVERY number so the running time is not that optimal (but still decent!). X and Y only decide whose destiny is “in” so it skips those unlucky guys. Moreover, Y optimizes on the algorithm to find those lucky guys so the running time is the optimal among them.

