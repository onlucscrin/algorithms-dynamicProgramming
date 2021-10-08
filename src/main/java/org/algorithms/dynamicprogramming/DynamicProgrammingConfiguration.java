package org.algorithms.dynamicprogramming;

import org.algorithms.dynamicprogramming.longestCommonSubsequence.LCSConfiguration;
import org.algorithms.dynamicprogramming.baseSetProblems.DPBaseProblemConfiguration;
import org.algorithms.dynamicprogramming.fibonacciProblems.FibonacciProblemConfiguration;
import org.algorithms.dynamicprogramming.unboundedKnapsack.UnboundedKnapsackConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({DPBaseProblemConfiguration.class, UnboundedKnapsackConfiguration.class, FibonacciProblemConfiguration.class, LCSConfiguration.class})
@Configuration
public class DynamicProgrammingConfiguration {
}
